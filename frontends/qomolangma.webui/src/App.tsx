import React from "react";
import {Route, Routes} from "react-router-dom";
import Root from "./pages/root";

const App = () => {
  return (
    <Routes>
      <Route path="/" element={<Root/>}/>
    </Routes>
  );
};
export default App;
