import React from 'react';
import {render, screen} from '@testing-library/react';
import App from '../App';

test('should renders App', () => {
    render(<App/>)
    const linkElement = screen.getByText(/learn react/i)
    expect(linkElement).toBeInTheDocument()
    const linkElement2 = screen.getByText(/Qomolangma frontend app./i)
    expect(linkElement2).toBeInTheDocument()
});
