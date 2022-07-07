import {render, screen} from "@testing-library/react";
import MultiLanguage from "../../components/MultiLanguage";
import {Format} from '../../locales/format';
import React from "react";

test('should multi language works', () => {
    render(<MultiLanguage ui={<p>{Format.format("test")}</p>}/>)
    const linkElement = screen.getByText(/test translate/i)
    expect(linkElement).toBeInTheDocument()
})

test('should multi language get default language', () => {
    const language = MultiLanguage.languageOrDefault("not-hit")
    expect(language).toBe('en-US')
})

test('should multi language get language in input', () => {
    const language = MultiLanguage.languageOrDefault("zh-CN")
    expect(language).toBe('zh-CN')
})
