import React from "react";
import {Route, Routes} from "react-router-dom";
import Root from "./pages/root";
import Login from "./pages/login";

const App = () => {
  return (
    <Routes>
      <Route path="/user/login" element={<Login/>}/>
      <Route path="/" element={<Root/>}/>
    </Routes>
  );
};
export default App;
