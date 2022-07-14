import {ENRender} from "../../ENRender";
import {screen} from "@testing-library/react";
import Login from "../../../pages/login"

test('should render Login page in English', () => {
  ENRender.render(new Login(null).render())
  const linkElement = screen.getByText(/UserName/i)
  expect(linkElement).toBeInTheDocument()
  const linkElement2 = screen.getByText(/Password/i)
  expect(linkElement2).toBeInTheDocument()
})
