type TittleProps = {
    children: string
}

export function TittleNav ( props: TittleProps) {

    return (
        <h1 className="text-[#D32F2F] font-Fascinate text-[3rem] text-shadow-sm text-shadow-[#884c38]">{props.children}</h1>
    )
}