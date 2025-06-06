import type { ComponentProps } from "react";
import { TittleBody } from "./tittle_body";

type OrderProps = {

    id: number,
    total_price: number,
    status: string,
    payment_method: string,
    created_at: Date,
    updated_at: Date

}

interface SideBarOrderProps extends ComponentProps<'div'> {
    
    orders: {

        order: OrderProps,

        qtd_itens: number

    } []
    

}

export function SideBarOrder ( props: SideBarOrderProps ) {

    console.log(props.orders)

    return (
        <div className="w-[25rem] bg-white shadow-xl rounded-lg p-5">
            <TittleBody className="text-[1.5rem] text-shadow-none">Histórico de Pedidos</TittleBody>
            <div className="mt-8">
                {props.orders.map((order) => 
                    <div className="flex justify-between items-center">
                        <div className="flex flex-col items-start">
                            <h1>#{order.order.id}</h1>
                            <h1>{order.order.total_price}</h1>
                            <h1>{order.qtd_itens}</h1>
                        </div>
                        <div>

                        </div>
                    </div>
                )}
            </div>
        </div>
    )
}