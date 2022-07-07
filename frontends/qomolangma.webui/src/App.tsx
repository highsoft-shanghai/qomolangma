import React from "react";
import {Route, Routes} from "react-router-dom";
import RootPage from "./pages/rootPage";

const App = () => {
    return (
        <Routes>
            <Route path="/" element={<RootPage/>}/>
        </Routes>
    );
};
export default App;
