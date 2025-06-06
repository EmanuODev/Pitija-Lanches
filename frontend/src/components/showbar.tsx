import { motion, AnimatePresence } from "framer-motion";
import { useState } from "react";
import { FaChevronUp, FaChevronDown } from "react-icons/fa";


type ShowBarProps = {

    options: string [],
    setCategory: Function

}

export function ShowBar ( props: ShowBarProps ) {

    const [ count, setCount ] = useState(0)
    const [ buttonStatus, setButtonStatus ] = useState(false)

    return (

        <div className="relative">
            
            <button onChange={props.setCategory(count)} onClick={(e) => {e.preventDefault(); setButtonStatus(!buttonStatus)}} className="relative w-full h-12 py-3 px-10 bg-[#D32F2F] flex justify-between font-Kanit items-center rounded-md shadow-submit border-2 border-[#424242]">
                <h1 className=" text-white text-[1.3rem]">{props.options[count]}</h1>
                {buttonStatus ? <FaChevronUp className="text-white text-[1.3rem]"/>  : <FaChevronDown className="text-white text-[1.3rem]"/> }
            </button>

            <AnimatePresence>
                { buttonStatus && 
                    <motion.ul initial={ { opacity: 0, translateY: 0} } animate={ { opacity: 1, translateY: 10} } className="absolute w-full">
                        { props.options.map((option, index) =>
                            <li className="w-full h-12 mb-1 py-3 px-4 flex justify-between items-center rounded-md bg-[#D32F2F] transition hover:scale-110 border-2 border-[#424242]">
                                <button onClick={(e) => {e.preventDefault(); setButtonStatus(!buttonStatus); setCount(index)}} className="w-full">
                                    <h1 className="text-white text-[1.3rem] font-Kanit w-full text-center">
                                        {option}
                                    </h1>
                                </button>
                            </li>
                        )}
                    </motion.ul>
                }
            </AnimatePresence>

        </div>

    )

}