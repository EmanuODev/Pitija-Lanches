import type { ComponentProps } from "react";
import { TittleBody } from "./tittle_body";
import { ViewProduct } from "./view_product";

type productProps = {

    id: number,
    name: string,
    description: string,
    image_url: string,
    category: string,
    price: number,
    stock: number

} 

interface ProductsCategoryProps extends ComponentProps<'div'> {

    products: productProps [],
    children: string,
    imageUrl: string

}

export function ProductsCategory ( props: ProductsCategoryProps ) {

    const user_id =  Number(localStorage.getItem('user_id'))

    return (
        <div className="flex flex-col pb-20">
            <TittleBody className="pb-6">{props.children}</TittleBody>
            <div className="grid grid-cols-2 2xl:grid-cols-4 w-full" >
                {props.products.map((product) =>
                    <ViewProduct key={product.id} user_id={user_id} photo={props.imageUrl} price={product.price} name={product.name} product_id={product.id} className="col-span-1"></ViewProduct> 
                )}
            </div>
        </div>
    )

}