// import type { ComponentProps } from "react";

import { useEffect, useState } from "react";
import { CartItens } from "../components/cart_itens";
import { Header } from "../components/header";
import { api } from "../api";

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

// interface CartProps extends ComponentProps<'div'> {

// }



export function Cart(  ) {

    const [cart, setCart] = useState<CartItensProps[]>([])

    const user_id = Number(localStorage.getItem('user_id'))

    useEffect (() => {

        api.get(`/cart/all/${user_id}`)
            .then(function (response) {
                setCart(response.data.cart)
            })
            .catch(function (error) {
                console.error(error)
            })

    }, [])

    return (
        <div className="h-screen w-full flex flex-col bg-[#fbf3f3]">
            <Header/>
            <div className="flex-1 w-full px-[5rem] py-10 flex justify-start overflow-hidden min-h-0">
                <CartItens itens={cart}></CartItens>
            </div>
        </div>
    )
}