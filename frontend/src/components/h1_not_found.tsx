import type { ComponentProps } from "react";
import { twMerge } from "tailwind-merge";

interface h1_props extends ComponentProps<'h1'> {
    children: string
}

export function H1NotFound ( props: h1_props ) {

    return ( <h1 className={twMerge("font-Fascinate text-[12rem] text-slate-700", props.className)}>{props.children}</h1>)

}