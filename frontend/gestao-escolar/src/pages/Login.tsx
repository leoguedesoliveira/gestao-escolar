import CustomInput from "../components/Input/CustomInput";
import api from "../services/api";
import Cookies from "js-cookie";
import Swal from 'sweetalert2'

import { Button } from "@mui/material";
import { useState } from "react";
import axios from "axios";
import { useNavigate } from "react-router-dom";

interface LoginRequest {
    email: string;
    senha: string;
  }
  
  interface LoginResponse {
    token: string;
  }
  
  interface ErrorResponse {
    message: string;
    status: number;
  }


const Login = () => {
    const navigate = useNavigate();
    const [email, setEmail] = useState("");
    const [senha, setSenha] = useState("");
    const [isLoading, setIsLoading] = useState(false);

    const handleSubmit = async (event: React.FormEvent<HTMLFormElement>) => {
        event.preventDefault();
        setIsLoading(true);

        try {
            const response = await api.post<LoginResponse>("/auth/login", { 
                email: email, 
                senha: senha 
            });
            
            const { token } = response.data;
            Cookies.set("authToken", token, { expires: 7 });
            
            navigate("/home")

        } catch (error) {
            if (axios.isAxiosError(error) && error.response?.data) {
                const errorData = error.response.data as ErrorResponse;
                
                await Swal.fire({
                    icon: 'error',
                    title: 'Erro ao fazer login',
                    text: errorData.message,
                    confirmButtonColor: '#3085d6'
                });
            } else {
                await Swal.fire({
                    icon: 'error',
                    title: 'Erro inesperado',
                    text: 'Ocorreu um erro ao tentar fazer login',
                    confirmButtonColor: '#3085d6'
                });
            }
        } finally {
            setIsLoading(false);
        }
    };

    return(
        <div className="h-screen w-screen flex justify-center items-center">
            <form onSubmit={handleSubmit} action="" className="w-2/5 h-2/4 bg-white rounded-xl flex flex-col items-center justify-center p-10">
                <div className="w-2/3">
                    <header className="text-center">
                        <h1 className="text-3xl">Gestão Escolar</h1>
                        <p className="text-gray-400">Seja bem vindo!</p>
                    </header>
                    <main className="flex flex-col mt-12 items-center">
                        <div className="w-80">
                            <div className="">
                                <CustomInput 
                                    type="email" 
                                    placeholder="E-mail"
                                    value={email}
                                    onChange={setEmail}
                                />
                            </div>
                            <div className="">
                                <CustomInput 
                                    type="password" 
                                    placeholder="Senha"
                                    value={senha}
                                    onChange={setSenha}
                                />
                            </div>
                        </div>
                    </main>
                    <footer className="flex justify-center mt-5">
                        <Button type="submit" className="w-70" variant="contained">Login</Button>
                    </footer>
                </div>
            </form>
        </div>
    );
}

export default Login;