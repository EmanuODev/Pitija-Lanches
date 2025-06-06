import type { ComponentProps } from "react";

interface InputProps extends ComponentProps<'input'> {

    placeholder: string,

}

export function Input ( props: InputProps ) {
    
    return (
        <input {...props} placeholder={props.placeholder} className="w-full px-3 py-2 mt-2 shadow-xl bg-[#BDBDBD] bg-opacity-25 border-2 text-[#884c38] border-[#424242] focus:border-[#884c38] focus:outline-none rounded-lg"></input>
    )

}