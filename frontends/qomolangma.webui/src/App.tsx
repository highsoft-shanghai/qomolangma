import React from "react";
import {Route, Routes} from "react-router-dom";
import Root from "./pages/root";
import Login from "./pages/login";
import Register from "./pages/register";

const App = () => {
  return (
    <Routes>
      <Route path="/user/login" element={<Login/>}/>
      <Route path="/user/register" element={<Register/>}/>
      <Route path="/" element={<Root/>}/>
    </Routes>
  );
};
export default App;
