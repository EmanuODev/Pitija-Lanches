import type { ComponentProps } from "react"

type ItemProps = {
    id: number,
    name: string,
    description: string | undefined,
    image_url: string,
    category: string,
    price: number,
    stock: number
}

type CartItensProps = {

    id: number,
    item: ItemProps,
    quantity: number,
    subtotal: number

}

interface ViewCartItemProps extends ComponentProps<'div'> {

    product: CartItensProps

}

export function ViewCartItem ( props: ViewCartItemProps ) {
    
    return(
        <div className="w-full border-2 p-3 rounded-xl min-h-32 flex items-center">
            <div className="flex items-start gap-7 w-[50%]">
                <img src={props.product.item.image_url} alt={props.product.item.category} className="h-[5rem] w-[6.8rem]"/>
                <div>
                    <h1 className="pt-1 text-[1.4rem]">{props.product.item.name}</h1>
                    <div className="flex items-center gap-2">
                        <h2>Categoria: </h2>
                        <h2 className="">{props.product.item.category === "DRINKS" ? "Bebida" : props.product.item.category === "HAMBURGER" ? "Hambúrguer" : props.product.item.category === "SALTY" ? "Salgado" : "Doce"}</h2>
                    </div>
                </div>
            </div>
            <div className="w-[25%] pl-3">
                <div className="w-28 h-9 bg-[#eeeeeee5] flex items-center divide-x-2">
                    <button className="w-[33%]">-</button>
                    <div className="w-[34%] text-center">{props.product.quantity}</div>
                    <button className="w-[33%]">+</button>
                </div>
            </div>
            <div className="w-[25%] pl-5">
                {props.product.subtotal.toLocaleString("pt-BR", { style: "currency", currency: "BRL" })}
            </div>
        </div>
    )

}