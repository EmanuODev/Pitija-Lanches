import type { ComponentProps } from "react";
import { TittleBody } from "./tittle_body";
import { RiDrinks2Fill } from "react-icons/ri";
import { PiCakeBold } from "react-icons/pi";
import { LuPizza } from "react-icons/lu";
import { PiHamburgerDuotone } from "react-icons/pi";


type OrderProps = {

    id: number,
    total_price: number,
    status: string,
    payment_method: string,
    created_at: Date,
    updated_at: Date

}

type SideBarOrderProps = {

    order: OrderProps,
    qtd_itens: number

}

type ItemProps = {

    id: number,
    item: {

        id: number,
        name: string,
        description: string,
        image_url: string,
        category: string,
        price: number,
        stock: number

    },
    quantity: number,
    subtotal: number

}

type OrderResponse = {

    order: OrderProps,
    itens: ItemProps [],
    qtd_itens: number

}

interface ShowItensOrderProps extends ComponentProps<'div'> {

    order: OrderResponse | undefined,
    qtd_itens: number

}

export function ShowItensOrder ( props: ShowItensOrderProps ) {


    return (
        <div className="w-[71.8rem] h-full bg-white shadow-div rounded-lg py-5 px-8 flex flex-col">
            <div className="flex items-center gap-4">
                <TittleBody className="text-shadow-none">Pedido #{String(props.order?.order.id)}</TittleBody>
                <h1 className="text-2xl text-gray-500">({props.qtd_itens})</h1>
            </div>
            <div className="mt-4 h-full flex flex-col overflow-y-auto gap-y-6">
                {props.order?.itens.map((order) =>
                    <div className="flex justify-between pr-4">

                        <div className="flex gap-4">
                            <img src="/bla.png" alt="" className="h-40 w-30 rounded-lg"/>
                            <div className="py-3">
                                <h1 className="mb-1 font-Inter font-bold text-[1.4rem]">{order.item.name}</h1>
                                <h1 className="text-gray-600 mb-3">{order.item.description? order.item.description : "Não há descrição"}</h1>
                                {order.item.category === "DRINKS" ? <div className="flex items-center gap-2"><RiDrinks2Fill /><h1>Bebida</h1></div>
                                :order.item.category === "HAMBURGER" ? <div className="flex items-center gap-2"><PiHamburgerDuotone />Hambúrguer<h1></h1></div>
                                :order.item.category === "SALTY" ? <div className="flex items-center gap-2"><LuPizza /><h1>Salgado</h1></div>
                                :<div className="flex items-center gap-1"><PiCakeBold /><h1></h1>Doce</div>}
                                <h1>{order.quantity} Itens</h1>
                            </div>
                        </div>

                        <div className="flex flex-col items-end gap-1">
                            <div className="flex pt-2 items-center gap-2">
                                <h1 className="text-[1.4rem] font-medium">{order.quantity}</h1>
                                <h1 className="text-[1.4rem] font-medium">X</h1>
                                <h1 className="text-[1.4rem] font-medium">{order.item.price.toLocaleString("pt-BR", { style: "currency", currency: "BRL" })}</h1>
                            </div>
                            <h1>{order.subtotal.toLocaleString("pt-BR", { style: "currency", currency: "BRL" })}</h1>
                        </div>

                    </div> 
                )}
            </div>
        </div>
    )
}