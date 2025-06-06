import { Route, Routes } from "react-router-dom";
import { Pages } from "./src/index"

export function Router () {


    return (

        <Routes>
            <Route path="/*" element={<Pages.NotFound />}></Route>
            <Route path="/inicio" element={<Pages.Home/>}></Route>
            <Route path="/cadastrar-produto" element={<Pages.CreateProduct/>}></Route>
            <Route path="/meus-pedidos" element={<Pages.Orders/>}></Route>
        </Routes>
        
    )

}