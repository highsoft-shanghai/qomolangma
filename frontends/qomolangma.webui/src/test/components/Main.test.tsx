import {render, screen} from '@testing-library/react';
import Main from "../../components/main/index"

test('should render Main', () => {
    render(new Main(null).render())
    const linkElement = screen.getByText(/learn react/i)
    expect(linkElement).toBeInTheDocument()
    const linkElement2 = screen.getByText(/Qomolangma frontend app./i)
    expect(linkElement2).toBeInTheDocument()
})
