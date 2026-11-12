import {useEffect} from "react";

function PunishPage({opponentCharacter, setMainCharacter, mainCharacter, punishes, setPage, characters, moveSearch,
                        opponentMoves, setPunishes, setOpponentCharacter,
                        setMoveSearch}){
    useEffect(()=>{
        console.log("Estado actual de moveSearch:", moveSearch.id);
        if(mainCharacter.name !== "none" && moveSearch.id !== null) {

            const matchedMove = opponentMoves.find(move => move.command === moveSearch)
            if (matchedMove) {
            console.log("Estado actual de matchedMove:", matchedMove);
            fetch(`/api/v1/punishments?characterId=${mainCharacter.id}&moveId=${matchedMove.id}`).then(response => response.json())
                .then(moves => {
                    const formatPunishes = moves.map(move => ({
                        id: move.id,
                        command: move.command,
                        startUp: move.startFrame,
                        damage: move.damage
                    }));
                    setPunishes(formatPunishes);
                    console.log("Estado actual de punished:", formatPunishes);
                })
            }
        }
    }, [mainCharacter, moveSearch]);



    return(
        <>
            <header id="title">
                <h1>
                    TEKKEN PUNISHMENT MATCHUP
                </h1>
            </header>
            <section id = "middle-block">
                <div id = "selected-character">
                    <button className="bt-return" onClick={()=>setPage("HomePage")}> Return to first character selection</button>
                    <img id={"picture"} src={opponentCharacter.portrait} alt="Foto del personaje"/>
                    <h2>{opponentCharacter.name}</h2>
                    <h3>{opponentCharacter.style}</h3>
                </div>
                <div id = "choose-character">
                    {mainCharacter.name === "none" ?(
                        <>
                            {characters.map(character => (
                                <button
                                    key={character.id}
                                    onClick={() => setMainCharacter(character)}
                                >
                                    <img src={character.icon} alt={character.name}/>
                                    <span>{character.name}</span>
                                </button>
                            ))}
                        </>) : (
                        <div id = "second-character">
                            <button
                                className="bt-return"
                                onClick={() => {
                                    setOpponentCharacter({name: "none", style: "none"});
                                    setMainCharacter({name: "none", style: "none"});
                                    setMoveSearch("");
                                    setPunishes([]);
                                    setPage("HomePage");
                                }}
                            >
                                Return to first character selection
                            </button>

                            <img id={"picture"} src={mainCharacter.portrait} alt="Foto del personaje"/>
                            <h2>{mainCharacter.name}</h2>
                            <h3>{mainCharacter.style}</h3>
                        </div>
                    )


                    }

                </div>
            </section>
            <section id="guaranteed-punishers">
                {mainCharacter.name !== "none" && (
                    punishes.length > 0 ? (
                        <table id="punishers-table">
                            <thead>
                            <tr>
                                <th>PUNISH</th>
                                <th>STARTUP</th>
                                <th>DAMAGE</th>
                            </tr>
                            </thead>
                            <tbody>
                            {punishes.map((punish) => (
                                <tr key={punish.id}>
                                    <td>{punish.command}</td>
                                    <td>{punish.startUp}</td>
                                    <td>{punish.damage}</td>
                                </tr>
                            ))}
                            </tbody>
                        </table>
                    ) : (
                        <div id="safe-move">SAFE ON BLOCK, NO PUNISH!</div>
                    )
                )}
            </section>
            <footer>

            </footer>

        </>
    )
}

export default PunishPage