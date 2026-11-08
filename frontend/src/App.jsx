
import './App.css'
import {useEffect, useId, useState} from "react";
import HomePage from "./pages/HomePage.jsx";
import PunishPage from "./pages/PunishPage.jsx";

function App() {
    const [opponentCharacter, setOpponentCharacter] = useState({id:"", name: "none", style: "none"});
    const [mainCharacter, setMainCharacter] = useState({name: "none", style: "none"});
    const [moveSearch, setMoveSearch] = useState("");
    const [page, setPage] = useState("HomePage");
    const [characters, setCharacters] = useState([]);
    const [punishes, setPunishes] = useState([]);
    const [opponentMoves, setOpponentMoves] = useState([]);
    const [moveAnswer, setMoveAnswer] = useState("");
    useEffect(() => {
        fetch('/api/v1/characters').then(response => response.json()).then(characters=> { const formatCharacters = characters.map(char =>({
            id: char.id,
            name: char.name,
            icon: `/characters/icons/${char.name}.png`,
            portrait: `/characters/portraits/${char.name}.png`


        }))
            setCharacters(formatCharacters);})


    }, []);

    useEffect(() => {
        if (opponentCharacter.id !== "") {
            console.log(opponentCharacter.id);
            fetch(`/api/v1/characters/${opponentCharacter.id}/moves`).then(response => response.json()).then(moves => {setOpponentMoves(moves), console.log(moves)})
        }
        console.log(opponentMoves);


    }, [opponentCharacter]);

    if (page === "HomePage"){
        return (
           <HomePage opponentCharacter={opponentCharacter}
                     setOpponentCharacter={setOpponentCharacter}
                     setPage={setPage}
                     characters={characters}
           setCharacters={setCharacters}
                     setMoveSearch={setMoveSearch}
                     moveSearch={moveSearch}/>
        );
    } else if (page === "PunishPage"){
        return(
            <PunishPage opponentCharacter={opponentCharacter}
                        setOpponentCharacter={setOpponentCharacter}
                        mainCharacter={mainCharacter}
                        setMainCharacter={setMainCharacter}
                      setPage={setPage}
                      setMoveSearch={setMoveSearch}
                      moveSearch={moveSearch}
                      punishes = {punishes}
                        setPunishes={setPunishes}
                        characters={characters}
                        setCharacters={setCharacters}
            setOpponentMoves={setOpponentMoves}
            opponentMoves={opponentMoves}/>

        );
    }

}

export default App
