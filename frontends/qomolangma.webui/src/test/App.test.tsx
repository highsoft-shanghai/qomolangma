import React from 'react';
import {render, screen} from '@testing-library/react';
import App from '../App';
import {BrowserRouter} from "react-router-dom";

test('should renders App', () => {
    render(<BrowserRouter><App/></BrowserRouter>)
    const linkElement = screen.getByText(/learn react/i)
    expect(linkElement).toBeInTheDocument()
    const linkElement2 = screen.getByText(/Qomolangma frontend app./i)
    expect(linkElement2).toBeInTheDocument()
});
