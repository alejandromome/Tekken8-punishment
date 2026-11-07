import {CHARACTERS} from "../assets/characters.js";
function PunishPage({opponentCharacter, setMainCharacter, mainCharacter, punishes, setPage}){
    return(
        <>
            <header id="title">
                <h1>
                    TEKKEN PUNISHMENT MATCHUP
                </h1>
            </header>
            <section id = "middle-block">
                <div id = "selected-character">
                    <img src={opponentCharacter.portrait} alt="Foto del personaje"/>
                    <h2>{opponentCharacter.name}</h2>
                    <h3>{opponentCharacter.style}</h3>
                </div>
                <div id = "choose-character">
                    {mainCharacter.name === "none" ?(
                        <div>
                            {CHARACTERS.map(character => (
                                <button key={character.id} onClick={()=> setMainCharacter(character)}>
                                <img src={character.icon} alt={character.name}/>
                                    <span>{character.name}</span>
                                </button>
                            ))}

                        </div>) : (
                        <div id = "second-character">
                            <img src={mainCharacter.portrait} alt="Foto del personaje"/>
                            <h2>{mainCharacter.name}</h2>
                            <h3>{mainCharacter.style}</h3>

                            <button onClick={()=> {setMainCharacter({name: "none", style:"none"}); }}>Select other character</button>
                        </div>
                    )


                    }

                </div>
            </section>
            <section id = "guaranteed-punishers">
                <table id={"punishers-table"}>
                    <thead>
                    <tr>
                        <th>PUNISH</th>
                        <th>STARTUP</th>
                        <th>DAMAGE</th>
                    </tr>
                    </thead>
                    <tbody>
                    {punishes.map((punish) => (
                        <tr>
                            <td> {punish.move}</td>
                            <td> {punish.startUp}</td>
                            <td> {punish.damage}</td>
                        </tr>
                    ))}
                    </tbody>
                </table>
            </section>
            <footer>
                Y AQUI ESTA EL FOOTER
                <button id = "bt-return" onClick={()=>setPage("HomePage")}> Return to character selection</button>
            </footer>

        </>
    )
}

export default PunishPage