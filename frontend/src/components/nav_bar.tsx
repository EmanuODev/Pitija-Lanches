import { FaShoppingCart } from "react-icons/fa";
import { FaCircleUser } from "react-icons/fa6";
import { ButtonNav } from "./button_nav";
import { TittleNav } from "./tittle_nav";


export function NavBar () {
    
    // #ff9d3e
    // #bc1e2e
    // #b37c46
    // #F5EBDC

    return (
        <nav className="w-full h-28 bg-[#ff9d3e] flex items-center justify-between px-[25rem] shadow-lg">
            <div className="flex items-center gap-8">
                <TittleNav>Pitija</TittleNav>
                <TittleNav>Lanches</TittleNav>
            </div>
            <div className="gap-14 flex items-center">
                <div className="relative">
                    {/* <div className="absolute px-[0.45rem] bg-[#F5EBDC] rounded-full translate-x-5 -translate-y-2 h-5 w-5 z-10"></div> */}
                    <ButtonNav ><FaShoppingCart/></ButtonNav>
                </div>
                <ButtonNav><FaCircleUser /></ButtonNav>
            </div>
        </nav>
    )

}