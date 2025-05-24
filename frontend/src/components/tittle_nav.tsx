type TittleProps = {
    children: string
}

export function TittleNav ( props: TittleProps) {

    return (
        <h1 className="text-[#da2235] font-fascinate text-[3rem]">{props.children}</h1>
    )
}