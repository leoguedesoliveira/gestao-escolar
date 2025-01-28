import React, { useState, useEffect } from 'react';
import api from "../services/api";
import {
  Table,
  TableBody,
  TableCell,
  TableContainer,
  TableHead,
  TableRow,
  Paper,
  Button,
  Dialog,
  DialogTitle,
  DialogContent,
  DialogActions,
  TextField,
  IconButton,
  Box,
  DialogContentText
} from '@mui/material';
import EditIcon from '@mui/icons-material/Edit';
import DeleteIcon from '@mui/icons-material/Delete';
import AddIcon from '@mui/icons-material/Add';
import Navbar from '../components/MenuNavBar/Navbar';

interface Escola {
  id: number;
  nome: string;
}

const CadastroEscolas = () => {
  const [escolas, setEscolas] = useState<Escola[]>([]);
  const [open, setOpen] = useState(false);
  const [openDelete, setOpenDelete] = useState(false);
  const [escolaSelecionada, setEscolaSelecionada] = useState<Escola | null>(null);
  const [nome, setNome] = useState('');
  const [isEditing, setIsEditing] = useState(false);

  const fetchEscolas = async () => {
    try {
      const response = await api.get<Escola[]>('/escola');
      setEscolas(response.data);
    } catch (error) {
      console.error('Erro ao buscar escolas:', error);
    }
  };

  useEffect(() => {
    fetchEscolas();
  }, []);

  const handleAddClick = () => {
    setIsEditing(false);
    setNome('');
    setOpen(true);
  };

  const handleEditClick = (escola: Escola) => {
    setIsEditing(true);
    setEscolaSelecionada(escola);
    setNome(escola.nome);
    setOpen(true);
  };

  const handleDeleteClick = (escola: Escola) => {
    setEscolaSelecionada(escola);
    setOpenDelete(true);
  };

  const handleClose = () => {
    setOpen(false);
    setEscolaSelecionada(null);
    setNome('');
    setIsEditing(false);
  };

  const handleCloseDelete = () => {
    setOpenDelete(false);
    setEscolaSelecionada(null);
  };

  const handleSave = async () => {
    try {
      if (isEditing && escolaSelecionada) {
        // Atualizar escola existente
        await api.put(`/escola/${escolaSelecionada.id}`, {
          nome: nome
        });
      } else {
        // Criar nova escola
        await api.post('/escola', {
          nome: nome
        });
      }
      
      await fetchEscolas();
      handleClose();
    } catch (error) {
      console.error('Erro ao salvar escola:', error);
    }
  };

  const handleDelete = async () => {
    if (!escolaSelecionada) return;

    try {
      await api.delete(`/escola/${escolaSelecionada.id}`);
      await fetchEscolas();
      handleCloseDelete();
    } catch (error) {
      console.error('Erro ao excluir escola:', error);
    }
  };

  return (
    <div>
        <Navbar />
        <div className='p-20'>
        <Box display="flex" justifyContent="flex-end" mb={2}>
            <Button
            variant="contained"
            color="primary"
            startIcon={<AddIcon />}
            onClick={handleAddClick}
            >
            Nova Escola
            </Button>
        </Box>

        <TableContainer component={Paper}>
            <Table>
            <TableHead>
                <TableRow>
                <TableCell>ID</TableCell>
                <TableCell>Nome</TableCell>
                <TableCell>Ações</TableCell>
                </TableRow>
            </TableHead>
            <TableBody>
                {escolas.map((escola) => (
                <TableRow key={escola.id}>
                    <TableCell>{escola.id}</TableCell>
                    <TableCell>{escola.nome}</TableCell>
                    <TableCell>
                    <IconButton
                        color="primary"
                        onClick={() => handleEditClick(escola)}
                    >
                        <EditIcon />
                    </IconButton>
                    <IconButton
                        color="error"
                        onClick={() => handleDeleteClick(escola)}
                    >
                        <DeleteIcon />
                    </IconButton>
                    </TableCell>
                </TableRow>
                ))}
            </TableBody>
            </Table>
        </TableContainer>

        {/* Dialog para criar/editar */}
        <Dialog open={open} onClose={handleClose}>
            <DialogTitle>
            {isEditing ? 'Editar Escola' : 'Nova Escola'}
            </DialogTitle>
            <DialogContent>
            <TextField
                autoFocus
                margin="dense"
                label="Nome da Escola"
                type="text"
                fullWidth
                value={nome}
                onChange={(e) => setNome(e.target.value)}
            />
            </DialogContent>
            <DialogActions>
            <Button onClick={handleClose}>Cancelar</Button>
            <Button onClick={handleSave} variant="contained" color="primary">
                Salvar
            </Button>
            </DialogActions>
        </Dialog>

        {/* Dialog de confirmação de exclusão */}
        <Dialog
            open={openDelete}
            onClose={handleCloseDelete}
        >
            <DialogTitle>
            Confirmar Exclusão
            </DialogTitle>
            <DialogContent>
            <DialogContentText>
                Tem certeza que deseja excluir a escola "{escolaSelecionada?.nome}"?
                Esta ação não pode ser desfeita.
            </DialogContentText>
            </DialogContent>
            <DialogActions>
            <Button onClick={handleCloseDelete}>Cancelar</Button>
            <Button onClick={handleDelete} variant="contained" color="error">
                Excluir
            </Button>
            </DialogActions>
        </Dialog>
        </div>
    </div>
  );
};

export default CadastroEscolas;