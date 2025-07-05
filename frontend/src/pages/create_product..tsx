import { useState } from "react";
import { api } from "../api";
import { ButtonSubmit } from "../components/button_submit";
import { Header } from "../components/header";
import { Input } from "../components/input";
import { ShowBar } from "../components/showbar";
import { TittleBody } from "../components/tittle_body";
import { TittleInput } from "../components/tittle_input";
import { useForm } from "react-hook-form";
import { ToastContainer, toast, Bounce } from 'react-toastify';

type ProductPostParam = {

    name: string,
    description: string,
    image_url: string,
    category: number,
    price: number,
    stock: number,    

}

export function CreateProduct() {

    const options = ["Bebida", "Hamburguer", "Salgado", "Doce"]

    const [ category, setCategory ] = useState(0)

    const { register, handleSubmit } = useForm()

    console.log(category)

    const Submit = ( data: any) => {
        
        const params: ProductPostParam = {
            name: data.name,
            description: data.description,
            image_url: "/image4",
            category: category,
            price: data.price,
            stock: data.stock
        }

        api.post('/product', params)
            .then( function (response){
                toast.success(response.data.message, {
                position: "top-right",
                autoClose: 5000,
                hideProgressBar: false,
                closeOnClick: false,
                pauseOnHover: true,
                draggable: true,
                progress: undefined,
                theme: "dark",
                transition: Bounce,
                });
            }).catch(function (response){
                console.error(response)
            })

    }

    return (
        <div className="min-h-screen w-full flex flex-col bg-[#fbf3f3]">

            <Header></Header>

            <div className="h-full flex flex-1 items-center px-[20rem]">

                <form onSubmit={handleSubmit(Submit)} className="w-full bg-white shadow-2xl rounded-lg px-20 py-16">

                    <TittleBody className="pb-14 text-[3rem]">Cadastro do Produto</TittleBody>

                    <div className="grid grid-cols-4 gap-x-8 items-end gap-y-12">
                        <label className="col-span-3" htmlFor="name">
                            <TittleInput required={true}>Nome do Produto</TittleInput>
                            <Input {...register('name')} type="text" name="name" placeholder="X-Burguer" required/>
                        </label>
                        <label className="col-span-1">
                            <ShowBar options={options} setCategory={setCategory}></ShowBar>
                        </label>
                        <label className="col-span-4" htmlFor="description">
                            <TittleInput required={false}>Descrição do Produto</TittleInput>
                            <Input {...register('description')} type="text" name="description" placeholder="Pão de Hambúrguer, Três carnes..."/>
                        </label>
                        <label className="col-span-2" htmlFor="price">
                            <TittleInput required={true}>Preço do Produto (R$)</TittleInput>
                            <Input {...register('price')} type="number" step="0.01" name="price" placeholder="12,00" required></Input>
                        </label>
                        <label className="col-span-2" htmlFor="stock">
                            <TittleInput required={true}>Estoque do Produto</TittleInput>
                            <Input {...register('stock')} type="number" name="stock" placeholder="25" required/>
                        </label>
                    </div>

                    <div className="w-full flex justify-end">
                        <ButtonSubmit className="mt-16"/>
                    </div>

                </form>

            </div>

            <ToastContainer />
        </div>
    )

}