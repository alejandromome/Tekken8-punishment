import {useEffect} from "react";

function PunishPage({opponentCharacter, setMainCharacter, mainCharacter, punishes, setPage, characters, moveSearch,
                        opponentMoves, setPunishes, setOpponentCharacter,
                        setMoveSearch}){
    {/*We call the backend given the move we need to punish, and the character we want to use, and we return the
    valid options*/}
    useEffect(()=>{
        if(mainCharacter.name !== "none" && moveSearch.id !== null) {

            const matchedMove = opponentMoves.find(move => move.command === moveSearch)
            if (matchedMove) {
            fetch(`/api/v1/punishments?characterId=${mainCharacter.id}&moveId=${matchedMove.id}`).then(response => response.json())
                .then(moves => {
                    const formatPunishes = moves.map(move => ({
                        id: move.id,
                        command: move.command,
                        startUp: move.startFrame,
                        damage: move.damage
                    }));
                    setPunishes(formatPunishes);
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
                {/*The character we want to punish*/}
                <div id = "selected-character">
                    <button className="bt-return" onClick={()=>{setPage("HomePage");
                        setPunishes([]);
                        setMainCharacter({name: "none", style: "none"});
                    }}> Return to first character selection</button>
                    <img id={"picture"} src={opponentCharacter.portrait} alt="Picture of the character selected"/>
                    <h2>{opponentCharacter.name}</h2>
                    <h3>{opponentCharacter.style}</h3>
                </div>
                {/*The character we want to use for the punishment*/}
                <div id = "choose-character">
                    {/*Until we select the character, we will show all of them, then,
                    once selected, we will show the image, exactly like the previous character*/}
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
                            {/*If the client wants to return to the second character, we need to clean our variables*/}
                            <button
                                className="bt-return"
                                onClick={() => {
                                    setMainCharacter({name: "none", style: "none"});
                                    setPunishes([]);
                                }}
                            >
                                Return to Second character selection
                            </button>

                            <img id={"picture"} src={mainCharacter.portrait} alt="Picture of the character selected"/>
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
        </>
    )
}

export default PunishPage