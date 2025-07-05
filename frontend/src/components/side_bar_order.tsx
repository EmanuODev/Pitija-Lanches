import { useState, type ComponentProps } from "react";
import { TittleBody } from "./tittle_body";
import { GrInProgress } from "react-icons/gr";
import { FaCheck } from "react-icons/fa6";
import dayjs from 'dayjs';
import relativeTime from 'dayjs/plugin/relativeTime';
import 'dayjs/locale/pt-br';
import { twMerge } from "tailwind-merge";

dayjs.extend(relativeTime);
dayjs.locale('pt-br')

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

    } [],

    count: number,
    setCount: Function    

}

export function SideBarOrder ( props: SideBarOrderProps ) {

    const months = ["Jan", "Fev", "Mar", "Abr", "Maio", "Jun", "Jul", "Ago", "Set", "Out", "Nov", "Dez"]

    console.log(props.orders)

    return (
        <div className="w-[35rem] h-full bg-white shadow-div rounded-lg py-5 pr-12">
            <TittleBody className="text-[2rem] text-shadow-none pl-7">Histórico de Pedidos</TittleBody>
            <div className="mt-3">
                {props.orders.map((order, index) => 
                    <button onClick={() => props.setCount(index)} className={twMerge("w-full flex items-center")}>

                        <div className={twMerge(index === props.count ? "border-l-[5px] border-[#D32F2F] h-24 mr-6" : " h-24 mr-[1.82rem]")}></div>
                        
                        <div className="flex justify-between items-center border-b-2 py-6 w-full">
                            <div className="flex flex-col items-start">
                                <h1 className="text-[1.5rem] font-Inter">#{order.order.id}</h1>
                                <h1 className="text-[1.3rem] font-Inter">{order.order.total_price.toLocaleString("pt-BR", { style: "currency", currency: "BRL" })}</h1>
                                <h1 className="font-Inter text-slate-700">{order.qtd_itens} Itens</h1>
                            </div>
                            <div className="flex flex-col items-end gap-1">

                                <div className="flex items-center gap-2">

                                    {order.order.status === "IN_PROGRESS" ?
                                        <GrInProgress className="text-blue-600 text-[1.2rem]"/> 
                                    :
                                        <FaCheck className="text-green-600 text-[1.3rem]"/>
                                    }

                                    {order.order.status === "IN_PROGRESS" ?
                                        <h1 className="text-blue-600 font-Inter font-semibold text-[1.1rem]">Em andamento</h1>
                                    :
                                        <h1 className="text-green-600 font-Inter font-semibold text-[1.3rem]">Finalizado</h1>
                                    }

                                </div>

                                <div>
                                    <h1>{months[new Date(order.order.updated_at).getMonth()]} {new Date(order.order.updated_at).getDate()}, as {new Date(order.order.updated_at).getHours()}:{new Date(order.order.updated_at).getMinutes()}</h1>
                                </div>

                            </div>
                        </div>
                    </button>
                )}
            </div>
        </div>
    )
}