from fastapi import FastAPI
from pydantic import BaseModel
import wikipediaapi


app = FastAPI()

wiki_wiki = wikipediaapi.Wikipedia('MTUCI_student', 'en')


def fetch_page(search: str):
    return wiki_wiki.page(search)


@app.get("/{search}")
def wiki_summary(search: str):
    page = fetch_page(search)
    if page.exists():
        return page.summary
    else:
        return 'Page not found!'


@app.get("/url/{search}")
def wiki_url(search: str):
    page = fetch_page(search)
    if page.exists():
        return page.fullurl
    else:
        return 'Page not found!'


class PageInfo(BaseModel):
    summary: str
    url: str


class SearchInput(BaseModel):
    search: str


@app.post('/')
def make_search(search_input: SearchInput):
    page = fetch_page(search_input.search)
    if page.exists():
        return PageInfo(summary=page.summary, url=page.fullurl)
    else:
        return 'Page not found!'
