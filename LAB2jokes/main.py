from fastapi import FastAPI
from pydantic import BaseModel
import pyjokes

app = FastAPI()


@app.get("/")
def joke():
    return pyjokes.get_joke()


@app.get("/{friend}")
def friends_joke(friend: str):
    return friend + " tells his joke: " + pyjokes.get_joke()


@app.get("/multi/{friend}")
def friends_joke(friend: str, joke_amount: int):
    result = ""
    for i in range(joke_amount):
        result += friend + F" tells his joke #{i + 1}: " + pyjokes.get_joke() + "\n"

    return result


class Joke(BaseModel):
    friend: str
    joke: str

class JokeInput(BaseModel):
    friend: str

@app.post("/")
def create_joke(joke_input: JokeInput):
    """Joke Generation"""
    return Joke(friend=joke_input.friend, joke=pyjokes.get_joke())
