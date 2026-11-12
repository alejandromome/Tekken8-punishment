

function HomePage({ opponentCharacter, setOpponentCharacter, setPage, setMoveSearch, moveSearch, characters }) {
    return(
        <>
            <header id="title">
                <h1>
                    TEKKEN PUNISHMENT
                </h1>
            </header>
            <section id = "middle-block">
                <div id = "selected-character">

                    {opponentCharacter.name !== "none" ? ( <>
                        <img id={"picture"} src={opponentCharacter.portrait} alt="Picture"/>
                        <h2>{opponentCharacter.name}</h2>
                        <h3>{opponentCharacter.style}</h3>
                <div id = "punishment-cage">

                    <input type= "text"
                           placeholder={"ENTER COMMAND (e.g. df2, 1,1,2)..."}
                           onChange={(e)=>setMoveSearch(e.target.value)} value={moveSearch}/>


                </div> </>
                    ) : (<div>CHOOSE THE CHARACTER YOU WANT TO PUNISH!</div>) }


                </div>
                <div id = "choose-character">
                    {characters.map(character => (
                        <button key={character.id} onClick={() => {
                            setOpponentCharacter(character);
                            setMoveSearch("");
                        }}>
                            <img src = {character.icon} alt={character.name}/>
                        </button>
                    ))}

                </div>
            </section>
            <footer id= "footer-hp">
                <button id = "bt-punishment" onClick={()=>setPage("PunishPage")}> PUNISH HIM</button>

            </footer>

        </>
    );

}
export default HomePage;