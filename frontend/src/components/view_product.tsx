import { Tooltip } from "@mui/material";
import type { ComponentProps } from "react";
import { FaCartPlus } from "react-icons/fa";
import { twMerge } from "tailwind-merge";
import { motion } from "framer-motion";

interface ViewProductProps extends ComponentProps<'div'>  {
    photo: string,
    price: number,
    name: string,
    product_id: number
}

export function ViewProduct ( props: ViewProductProps) {

    return (
        <motion.div className={twMerge("h-[23rem] w-[20.5rem] items-center rounded-xl shadow-xl overflow-hidden transition cursor-pointer")} initial={ { opacity: 0, scale: 0.8 } } whileInView={ {opacity: 1, scale: 1 } } whileHover={ {scale: 1.05} } transition={ { duration: 0.1 } }>

            <Tooltip title={props.name} placement="right" arrow>
                
                <div className="h-[80%] bg-[#F2E5D4] flex flex-col items-center justify-between pt-4 pb-2">

                    <img src={props.photo} alt={props.name} className="w-[90%] h-[70%]"/>

                    <div className="w-full bg-[#F2E5D4] flex items-center justify-between px-5 gap-x-2">

                        <h1 className="text-[1.7rem] text-[#884c38] font-Outfit font-semibold truncate">{props.name}</h1>

                        <div className="flex items-end gap-1">
                            <h1 className="text-[#D32F2F] font-Outfit font-bold text-[1.1rem] pb-[0.55rem]">R$</h1>
                            <h1 className="text-[#D32F2F] font-Outfit font-bold text-[2.4rem]">{props.price.toFixed(2).replace('.', ',')}</h1>
                        </div>

                    </div>  

                </div>

            </Tooltip>

            <div className="h-[20%] w-full bg-white flex items-center justify-between px-7 border-r-2 border-l-2 border-b-2 border-[#F2E5D4] rounded-b-xl">

                <button className="h-10 w-16 bg-[#D32F2F] hover:bg-[#b32828] rounded-xl  flex items-center justify-center shadow-[0px_2px_1px_2px_rgba(0,0,0,0.2)] hover:shadow-none transition ease-in-out duration-200"><FaCartPlus className="text-[#FFF3E0] text-[1.3rem]"/></button>

                <button className="bg-[#FFFFFF] h-10 w-40 rounded-lg border-2 border-[#D32F2F] flex items-center justify-center gap-3 text-[#884c38] shadow-[0px_2px_1px_2px_rgba(0,0,0,0.2)] hover:shadow-none hover:bg-[#D32F2F] hover:bg-opacity-10 transition">
                    <h1 className="pb-[0.1rem]">+</h1>
                    <h1 className="font-serif font-medium">Veja mais</h1>
                </button>

            </div>

        </motion.div>
    )
}