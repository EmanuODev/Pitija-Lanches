import { useState } from "react"
import { ProductsCategory } from "./products_category"

type productProps = {

    id: number,
    name: string,
    description: string,
    image_url: string,
    category: string,
    price: number,
    stock: number

} 

type productsJsonProps = {

    products: {

        hamburgers: productProps [],
        salty: productProps [],
        sugary: productProps [],
        drinks: productProps [],

    },

    filterOptions: {
        name: string,
        checkbox: boolean
    }[]

}

export function DivProducts( props: productsJsonProps ) {

    function EveryFalse (){
        return props.filterOptions.every(filter => filter.checkbox === false)
    }

    return (

        <div>

            { (props.products.hamburgers.length > 0 && (props.filterOptions[0].checkbox || EveryFalse()) ) && <ProductsCategory imageUrl="../../public/foto_hamburger.png" products={props.products.hamburgers}>Hamburguers</ProductsCategory>}
            
            { (props.products.salty.length > 0 && (props.filterOptions[1].checkbox || EveryFalse()) ) && <ProductsCategory imageUrl="../../public/coxinha.png" products={props.products.salty}>Salgados</ProductsCategory>}
    
            { (props.products.sugary.length > 0 && (props.filterOptions[2].checkbox || EveryFalse()) ) && <ProductsCategory imageUrl="../../public/bolo.png" products={props.products.sugary}>Doces</ProductsCategory>}
    
            { (props.products.drinks.length > 0 && (props.filterOptions[3].checkbox || EveryFalse()) ) && <ProductsCategory imageUrl="../../public/limoneto.png" products={props.products.drinks}>Bebidas</ProductsCategory>}

        </div>

    )
}