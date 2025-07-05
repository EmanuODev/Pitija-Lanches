import { Header } from "../components/header";
import { useEffect, useState } from "react";
import { api } from "../api";
import { SideBarOrder } from "../components/side_bar_order";
import { ShowItensOrder } from "../components/show_itens_order";

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

type OrdersResponseProps = {

    user: {

        id: number,
		name: string,
		email: string,
		phone: string,
		role: string 

    },

    orders: OrderResponse [],

    message: string

}

export function Orders () {

    const [count, setCount] = useState(0)

    const [responseData, setResponseData] = useState<OrdersResponseProps>()

    const [orders, setOrders] = useState<SideBarOrderProps[]>([])
    
    const user_id =  Number(localStorage.getItem('user_id'))

    function createOrders ( ordersReponse: OrderResponse[] ) {

        ordersReponse.map((order) => {

            if(!orders.some((temp_order) => temp_order.order.id === order.order.id)) {

                setOrders(prevOrders => [
                    ...prevOrders,
                    {
                        order: order.order,
                        qtd_itens: order.qtd_itens
                    }
                ])

            }

        })

    }

    useEffect(() => {

        const showOrders = () => {
            
            api.get(`/order/all/${user_id}`)

            .then( function (response) {

                setResponseData(response.data)

                if (response.data.orders)
                    createOrders(response.data.orders)
                

            }).catch( function (response) {

                console.error(response)

            })

        }

        showOrders()

    }, [])

    console.log(orders)
    console.log(responseData)

    return(
        <>
            {orders.length > 0 &&
                <div className="h-screen w-full flex flex-col bg-[#fbf3f3]">
                    <Header />
                    <main className="flex-1 w-full px-[5rem] py-10 flex justify-start gap-12 overflow-hidden">
                        <SideBarOrder count={count} setCount={setCount} orders={orders} />
                        <ShowItensOrder qtd_itens={orders[count].qtd_itens} order={responseData?.orders[count]} />
                    </main>
                </div>
            }
        </>
    )
}