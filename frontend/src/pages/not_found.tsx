import { H1NotFound } from "../components/h1_not_found";
import { motion } from "framer-motion";

export function NotFound () {

    return (
        <main className="relative h-screen w-full">
            
            <div className="absolute inset-0 bg-[url('/not_found.svg')] opacity-80 z-0" />

            <div className="relative h-screen z-10 w-full flex justify-center items-center pl-32">
                <div className="flex flex-col pr-7 gap-y-8">
                    <div className="flex flex-col text-center items-center">
                        <motion.div animate={ { translateX: [0, 50, 0] } } transition={ { duration: 4, repeat: Infinity, repeatType: "mirror" } }><H1NotFound>Error</H1NotFound></motion.div>
                        <ul className="flex items-center -translate-y-14">
                            <motion.li animate={ { translateY: [0, -50, 20] } } transition={ { duration: 3, repeat: Infinity, repeatType: "mirror" } } ><H1NotFound>4</H1NotFound></motion.li>
                            <motion.li animate={ { translateY: [-10, -60, 0] } } transition={ { duration: 5, repeat: Infinity, repeatType: "mirror" } } ><H1NotFound>0</H1NotFound></motion.li>
                            <motion.li animate={ { translateY: [-20, -60, -10] } } transition={ { duration: 3, repeat: Infinity, repeatType: "mirror" } } ><H1NotFound>4</H1NotFound></motion.li>
                        </ul>
                    </div>
                    <motion.h1 animate={ { translateX: [0, 50, 0] } } transition={ { duration: 4, repeat: Infinity, repeatType: "mirror" } } className="text-center text-[8rem] font-fascinate text-[#f18822]">NOT FOUND</motion.h1>
                </div>
                <motion.img animate={ {x: [0, 50, 0], scale: [0.9, 1, 0.9]} } transition={{duration: 3, repeat: Infinity, repeatType: "mirror"}} src="../../public/hamburguer.svg" alt="hamburguer" className="h-[55rem]"/>
            </div>
        </main>
    );
}