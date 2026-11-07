
import './App.css'
import {useId, useState} from "react";
import HomePage from "./pages/HomePage.jsx";
import PunishPage from "./pages/PunishPage.jsx";

function App() {
    const [opponentCharacter, setOpponentCharacter] = useState({name: "none", style: "none"});
    const [mainCharacter, setMainCharacter] = useState({name: "none", style: "none"});
    const [moveSearch, setMoveSearch] = useState("");
    const [page, setPage] = useState("HomePage")
    const punishes = [
        { move: "1, 2", startUp: "i10", damage: "17" },
        { move: "f+1+2", startUp: "i12", damage: "25" },
        { move: "df+2", startUp: "i15", damage: "Launch" }
    ];
    if (page === "HomePage"){
        return (
           <HomePage opponentCharacter={opponentCharacter}
                     setOpponentCharacter={setOpponentCharacter}
                     setPage={setPage} />
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
                      />

        );
    }

}

export default App
