import type { ComponentProps } from "react";

interface TittleInputProps extends ComponentProps<'h1'> {

    children: string,
    required: boolean

}

export function TittleInput ( props: TittleInputProps ) {
    
    return (

        <div className="flex items-center gap-x-1">
            <h1 className="text-[1.4rem] text-[#424242] font-Kanit font-medium">{props.children}</h1>
            {props.required && <h1 className="text-red-600">*</h1>}
        </div>

    )
}