import { FaPlus } from "react-icons/fa";
import Tooltip from '@mui/material/Tooltip';
import { Filter } from "./filter";
import { useNavigate } from "react-router-dom";

type NavBarProps = {

    handleSearch: Function,
    filterOptions: OptionsProps[],
    setFilterOptions: Function

}

type OptionsProps = {

    name: string,
    checkbox: boolean

}

export function NavBar ( props: NavBarProps ) {
    
    // #ff9d3e
    // #bc1e2e
    // #b37c46
    // #F5EBDC
    
    const navigate = useNavigate();

    return (
        <div className="flex items-center justify-between pb-12">

            {/* <TittleBody className="text-[4rem]">Para você</TittleBody> */}

            <div className="mt-5">
                <Filter setFilterOptions={props.setFilterOptions} filterOptions={props.filterOptions}></Filter>
            </div>

            <input type="search" onChange={(e) => {props.handleSearch(e.target.value)}} className="h-12 mt-5 w-[25rem] px-4 rounded-xl outline-none border-2 border-[#D32F2F] placeholder:text-[#884c38] text-[#884c38] placeholder:text-opacity-50" placeholder="Busque aqui"/>

            <div className="flex items-center gap-10 mt-5">
                <Tooltip title="Cadastrar produto" arrow><button onClick={() => navigate('/cadastrar-produto')} className="h-12 w-12 bg-[#D32F2F] rounded-xl flex items-center justify-center shadow-[0px_2px_1px_2px_rgba(0,0,0,0.2)]"><FaPlus className="text-[#FFF3E0]"/></button></Tooltip>
            </div>

        </div>
    )

}