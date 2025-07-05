import type { ComponentProps } from "react";
import { TittleBody } from "./tittle_body";
import { ViewCartItem } from "./view_cart_item";

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

interface CartProps extends ComponentProps<'div'> {

    itens: CartItensProps [],


}

export function CartItens( props: CartProps ) {
    
    return ( 
        <div className="w-[71.8rem] h-full bg-white shadow-div rounded-lg py-5 px-8 flex flex-col divide-y-2 overflow-hidden">
            <TittleBody className="text-shadow-none mb-2">Meu Carrinho</TittleBody>
            <div className="pt-6 w-full flex flex-col flex-1 min-h-0">
                <div className="w-full flex items-center mb-3">
                    <h3 className="w-[50%] text-start pl-6">Produto</h3>
                    <h3 className="w-[25%] text-start">Quantidade</h3>
                    <h3 className="w-[25%] text-start">Preço</h3>
                </div>
                <div className="flex flex-col flex-1 overflow-y-auto gap-6 pr-3">
                    {props.itens.map((item) => 
                        <ViewCartItem key={item.id} product={item}></ViewCartItem>
                    )}
                </div>
            </div>
        </div>
    )

}