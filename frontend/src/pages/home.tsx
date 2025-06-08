import { NavBar } from "../components/nav_bar";
import { useEffect, useState } from "react";
import { api } from "../api";
import { DivProducts } from "../components/div_products";
import { Header } from "../components/header";

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

    hamburgers: productProps [],
    salty: productProps [],
    sugary: productProps [],
    drinks: productProps [],

}

type OptionsProps = {

    name: string,
    checkbox: boolean

}

export function Home () {

    const user_id = 1

    localStorage.setItem("user_id", JSON.stringify(user_id));

    const [ filterOptions, setFilterOptions ] = useState<OptionsProps[]>( [ { name: "Hamburguers", checkbox: false }, { name: "Salgados", checkbox: false }, { name: "Doces", checkbox: false }, { name: "Bebidas", checkbox: false } ] )

    const [ search, setSearch ] = useState("")

    const [ products, setProducts ] = useState<productsJsonProps>( { hamburgers: [], salty: [], sugary: [], drinks: [] } )
    const [ tempProducts, setTempProducts ] = useState<productsJsonProps>( { hamburgers: [], salty: [], sugary: [], drinks: [] } )
    
    
    function handleSearch( search: string) {
        
        setSearch(search)

        setTempProducts({
            
            hamburgers: products.hamburgers.filter((hamburger) => (hamburger.name.trim().toLowerCase()).startsWith(search.trim().toLowerCase())),
            salty: products.salty.filter((salty) => (salty.name.trim().toLowerCase()).startsWith(search.trim().toLowerCase())),
            sugary: products.sugary.filter((sugary) => (sugary.name.trim().toLowerCase()).startsWith(search.trim().toLowerCase())),
            drinks: products.drinks.filter((drinks) => (drinks.name.trim().toLowerCase()).startsWith(search.trim().toLowerCase())),
            
        })

    }
    // #ff9d3e
    // #bc1e2e
    // #b37c46
    // #F5EBDC

    useEffect (() => {

        const loadProducts = async () => {

            await api.get("/product")
                    .then(function (response) {
                        setProducts(response.data)
                        console.log(response.data)
                    }).catch(function (error) {
                        console.error(error)
                    });

        }

        loadProducts();

    }, [])

    console.log(search)

    return (
        
        <div className="min-h-screen w-full bg-[#fbf3f3] flex flex-col">

            <Header></Header>

            {products && 
                <div className="h-full px-[10rem] lg:px-[14rem] 2xl:px-[7rem] pt-16">

                    <NavBar handleSearch={handleSearch} setFilterOptions={setFilterOptions} filterOptions={filterOptions}></NavBar>

                    {search.length > 0 ?

                        <DivProducts products={tempProducts} filterOptions={filterOptions}></DivProducts>

                        :

                        <DivProducts products={products} filterOptions={filterOptions}></DivProducts>
                    }

                
                </div>
            }
        </div>

    );
}