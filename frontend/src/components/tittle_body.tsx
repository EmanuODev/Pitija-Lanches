import type { ComponentProps } from "react";
import { twMerge } from "tailwind-merge";

interface TittleBodyProps extends ComponentProps<'h1'> {
    children: string
}

export function TittleBody(props: TittleBodyProps) {


    return (
        <h1 className={twMerge("text-[2.2rem] text-[#884c38] font-Kanit font-bold text-shadow-sm text-shadow-gray-300", props.className)}>
            {props.children}
        </h1>
    )
}