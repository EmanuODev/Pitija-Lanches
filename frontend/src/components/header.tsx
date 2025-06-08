import { FaClipboardList, FaShoppingCart } from "react-icons/fa";
import { FaCircleUser } from "react-icons/fa6";
import { ButtonNav } from "./button_nav";
import { TittleNav } from "./tittle_nav";
import Tooltip from '@mui/material/Tooltip';
import { useNavigate } from "react-router-dom";
import urlFoto from '../../public/logo.svg'
export function Header () {

    const navigate = useNavigate()
    
    // #ff9d3e
    // #bc1e2e
    // #b37c46
    // #F5EBDC

    

    return (
        <nav className="w-full h-32 bg-[#fcb23c] flex items-center justify-between px-[7rem] shadow-lg">
            <button onClick={() => navigate('/inicio')} className="flex items-center gap-5">
                <img src={urlFoto} alt="logo" className="h-28"/>
            </button>
            <div className="gap-x-14 flex items-center">
                <Tooltip title="Meus Pedidos" arrow><ButtonNav url="/meus-pedidos"><FaClipboardList /></ButtonNav></Tooltip>
                <Tooltip title="Meu Carrinho" arrow><ButtonNav url="/inicio"><FaShoppingCart/></ButtonNav></Tooltip>
                <Tooltip title="Configurações do Usuário" arrow><ButtonNav url="/inicio"><FaCircleUser /></ButtonNav></Tooltip>
            </div>
        </nav>
    )

}