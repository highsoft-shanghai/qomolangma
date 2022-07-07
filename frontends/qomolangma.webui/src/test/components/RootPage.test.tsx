import {screen} from '@testing-library/react';
import RootPage from "../../components/rootPage"
import {ENRender} from "../ENRender";

test('should render Main', () => {
    ENRender.render(new RootPage(null).render())
    const linkElement = screen.getByText(/learn react/i)
    expect(linkElement).toBeInTheDocument()
    const linkElement2 = screen.getByText(/Qomolangma frontend app./i)
    expect(linkElement2).toBeInTheDocument()
})
