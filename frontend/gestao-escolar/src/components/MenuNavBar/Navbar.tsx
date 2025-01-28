import React, { useState } from 'react';
import { ChevronDown, LogOut, User } from 'lucide-react';
import Cookies from 'js-cookie';
import { useNavigate } from 'react-router-dom';

// Tipos para nossa estrutura de menu
type SubMenuItem = {
  label: string;
  path: string;
  roles: string[];
};

type MenuItem = {
  label: string;
  path?: string;
  roles: string[];
  subItems?: SubMenuItem[];
};

// Configuração do menu - fácil de expandir
const menuItems: MenuItem[] = [
  {
    label: 'Home',
    path: '/home',
    roles: ['ADMIN', 'DIRECTOR', 'USER']
  },
  {
    label: 'Configuração',
    roles: ['ADMIN'],
    subItems: [
      {
        label: 'Escolas',
        path: '/escolas',
        roles: ['ADMIN']
      },
      {
        label: 'Unidades',
        path: '/unidades',
        roles: ['ADMIN', 'DIRECTOR']
      },
      {
        label: 'Usuários',
        path: '/usuarios',
        roles: ['ADMIN', 'DIRECTOR']
      }
    ]
  },
  {
    label: 'Pré Cadastros',
    roles: ['ADMIN', 'USER', 'DIRECTOR'],
    subItems: [
      
    ]
  },
  {
    label: 'Acadêmico',
    roles: ['ADMIN', 'USER', 'DIRECTOR'],
    subItems: [
      
    ]
  }
];

const Navbar = () => {
  const [openDropdown, setOpenDropdown] = useState<string | null>(null);
  const navigate = useNavigate();
  
  // Simula obter a role do usuário - ajuste conforme sua implementação
  const userRole = 'ADMIN'; // Substitua pela lógica real de obter a role
  
  const handleMouseEnter = (label: string) => {
    setOpenDropdown(label);
  };

  const handleMouseLeave = () => {
    setOpenDropdown(null);
  };

  const handleLogout = () => {
    Cookies.remove('authToken');
    navigate('/login');
  };

  // Filtra itens do menu baseado na role do usuário
  const filteredMenuItems = menuItems.filter(item => 
    item.roles.includes(userRole)
  );

  return (
    <nav className="bg-white shadow-md w-full fixed top-0 left-0 z-50">
      <div className="max-w-7xl mx-auto px-4">
        <div className="flex justify-between h-16">
          {/* Logo */}
          <div className="flex-shrink-0 flex items-center">
            <span className="text-2xl font-bold text-black">LGTech</span>
          </div>

          {/* Menu Principal */}
          <div className="flex">
            {filteredMenuItems.map((item) => (
              <div
                key={item.label}
                className="relative"
                onMouseEnter={() => handleMouseEnter(item.label)}
                onMouseLeave={handleMouseLeave}
              >
                <div
                  className={`flex items-center h-16 px-4 cursor-pointer text-gray-800 hover:text-cyan-500 transition-colors ${
                    openDropdown === item.label ? 'text-cyan-500' : ''
                  }`}
                  onClick={() => item.path && navigate(item.path)}
                >
                  <span>{item.label}</span>
                  {item.subItems && (
                    <ChevronDown className="ml-1 w-4 h-4" />
                  )}
                </div>

                {/* Dropdown */}
                {item.subItems && openDropdown === item.label && (
                  <div className="absolute top-16 left-0 w-48 bg-white shadow-lg rounded-b-lg py-2">
                    {item.subItems
                      .filter(subItem => subItem.roles.includes(userRole))
                      .map((subItem) => (
                        <div
                          key={subItem.label}
                          className="px-4 py-2 text-gray-800 hover:bg-blue-50 hover:text-cyan-500 cursor-pointer"
                          onClick={() => navigate(subItem.path)}
                        >
                          {subItem.label}
                        </div>
                      ))}
                  </div>
                )}
              </div>
            ))}
          </div>

          {/* Perfil e Logout */}
          <div className="flex items-center space-x-4">
            <button
              className="flex items-center text-gray-800 hover:text-cyan-600"
              onClick={() => navigate('/profile')}
            >
              <User className="w-5 h-5 mr-1" />
              <span>Perfil</span>
            </button>
            <button
              className="flex items-center text-gray-800 hover:text-red-600"
              onClick={handleLogout}
            >
              <LogOut className="w-5 h-5 mr-1" />
              <span>Sair</span>
            </button>
          </div>
        </div>
      </div>
    </nav>
  );
};

export default Navbar;