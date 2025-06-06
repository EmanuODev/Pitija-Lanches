import type { ComponentProps } from "react";
import { twMerge } from "tailwind-merge";

interface ButtonSubmitProps extends ComponentProps<'input'> {

}

export function ButtonSubmit ( props: ButtonSubmitProps ) {
    
    return (
        <button className={twMerge("bg-green-600 hover:bg-green-700 focus:bg-green-500 transition ease-in-out px-12 py-3 rounded-lg text-white font-bold shadow-submit hover:shadow-lg", props.className)}>
            Enviar
        </button>
    )
}