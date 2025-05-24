import type { ComponentProps, ReactNode } from "react";

interface ButtonProps extends ComponentProps<'button'> {
    children: ReactNode
}


export function ButtonNav ( props: ButtonProps ) {


    return (
        <button className="text-[2.2rem] text-[#da2235]">
            {props.children}
        </button>
    );
}