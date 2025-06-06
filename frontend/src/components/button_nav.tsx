import type { ComponentProps, ReactNode } from "react";
import { useNavigate } from "react-router-dom";

interface ButtonProps extends ComponentProps<'button'> {

    children: ReactNode,
    url: string
    
}


export function ButtonNav ( props: ButtonProps ) {

    const navigate = useNavigate()

    return (
        <button {...props} onClick={() => navigate(props.url)} className="text-[2.4rem] text-[#C62828] transition hover:scale-110 rounded-full p-3 hover:bg-[#FFF3E0] hover:bg-opacity-50">
            {props.children}
        </button>
    );
}