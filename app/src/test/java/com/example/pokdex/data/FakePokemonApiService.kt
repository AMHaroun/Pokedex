package com.example.pokdex.data

import com.example.pokdex.network.PokemonApiService
import com.example.pokdex.network.responses.Ability
import com.example.pokdex.network.responses.AbilityX
import com.example.pokdex.network.responses.AffectingMoves
import com.example.pokdex.network.responses.AffectingNatures
import com.example.pokdex.network.responses.Animated
import com.example.pokdex.network.responses.BlackWhite
import com.example.pokdex.network.responses.Characteristic
import com.example.pokdex.network.responses.Crystal
import com.example.pokdex.network.responses.DiamondPearl
import com.example.pokdex.network.responses.DreamWorld
import com.example.pokdex.network.responses.Emerald
import com.example.pokdex.network.responses.FireredLeafgreen
import com.example.pokdex.network.responses.Form
import com.example.pokdex.network.responses.GameIndice
import com.example.pokdex.network.responses.GenerationI
import com.example.pokdex.network.responses.GenerationIi
import com.example.pokdex.network.responses.GenerationIii
import com.example.pokdex.network.responses.GenerationIv
import com.example.pokdex.network.responses.GenerationV
import com.example.pokdex.network.responses.GenerationVi
import com.example.pokdex.network.responses.GenerationVii
import com.example.pokdex.network.responses.GenerationViii
import com.example.pokdex.network.responses.Gold
import com.example.pokdex.network.responses.HeartgoldSoulsilver
import com.example.pokdex.network.responses.HeldItem
import com.example.pokdex.network.responses.Home
import com.example.pokdex.network.responses.Icons
import com.example.pokdex.network.responses.Item
import com.example.pokdex.network.responses.Language
import com.example.pokdex.network.responses.Move
import com.example.pokdex.network.responses.MoveLearnMethod
import com.example.pokdex.network.responses.MoveX
import com.example.pokdex.network.responses.Name
import com.example.pokdex.network.responses.OfficialArtwork
import com.example.pokdex.network.responses.OmegarubyAlphasapphire
import com.example.pokdex.network.responses.Other
import com.example.pokdex.network.responses.Platinum
import com.example.pokdex.network.responses.Pokemon
import com.example.pokdex.network.responses.PokemonList
import com.example.pokdex.network.responses.PokemonStat
import com.example.pokdex.network.responses.RedBlue
import com.example.pokdex.network.responses.Result
import com.example.pokdex.network.responses.RubySapphire
import com.example.pokdex.network.responses.Silver
import com.example.pokdex.network.responses.Species
import com.example.pokdex.network.responses.Sprites
import com.example.pokdex.network.responses.Stat
import com.example.pokdex.network.responses.StatX
import com.example.pokdex.network.responses.Type
import com.example.pokdex.network.responses.TypeX
import com.example.pokdex.network.responses.UltraSunUltraMoon
import com.example.pokdex.network.responses.Version
import com.example.pokdex.network.responses.VersionDetail
import com.example.pokdex.network.responses.VersionGroup
import com.example.pokdex.network.responses.VersionGroupDetail
import com.example.pokdex.network.responses.Versions
import com.example.pokdex.network.responses.XY
import com.example.pokdex.network.responses.Yellow

class FakePokemonApiService : PokemonApiService {

    // All methods model responses given from https://pokeapi.co/api/v2 on 12/22/23
    override suspend fun getPokemon(pokemonName: String): Pokemon {

        if(pokemonName == "ThrowException")
        {
            throw Exception(message = "Network Error")
        }

        // Models network response from https://pokeapi.co/api/v2/pokemon/ditto on 12/22/2023
        return Pokemon(
            height = 3,
            weight = 40,
            id = 132,
            name = "ditto",
            baseExperience = 101,
            isDefault = true,
            order = 214,
            stats = listOf(
                Stat(48, 1, StatX("hp", "https://pokeapi.co/api/v2/stat/1/")),
                Stat(48, 0, StatX("attack", "https://pokeapi.co/api/v2/stat/2/")),
                Stat(48,0, StatX("defense", "https://pokeapi.co/api/v2/stat/3/")),
                Stat(48, 0, StatX("special-attack", "https://pokeapi.co/api/v2/stat/4/")),
                Stat(48,0, StatX("special-defense", "https://pokeapi.co/api/v2/stat/5/")),
                Stat(48,0, StatX("speed", "https://pokeapi.co/api/v2/stat/6/"))
            ),
            types = listOf(
                Type(1, TypeX("normal", "https://pokeapi.co/api/v2/type/1/"))
            ),
            abilities = listOf(
                Ability(AbilityX("limber", "https://pokeapi.co/api/v2/ability/7/"), false, 1)
            ),
            forms = listOf(
                Form("ditto", "https://pokeapi.co/api/v2/pokemon-form/132/")
            ),
            gameIndices = listOf(
                GameIndice(76, Version("red", "https://pokeapi.co/api/v2/version/1/")),
                GameIndice(76, Version("blue", "https://pokeapi.co/api/v2/version/2/")),
                GameIndice(76, Version("yellow", "https://pokeapi.co/api/v2/version/3/")),
                GameIndice(132, Version("gold", "https://pokeapi.co/api/v2/version/4/")),
                GameIndice(132, Version("silver", "https://pokeapi.co/api/v2/version/5/")),
                GameIndice(132, Version("crystal", "https://pokeapi.co/api/v2/version/6/")),
                GameIndice(132, Version("ruby", "https://pokeapi.co/api/v2/version/7/")),
                GameIndice(132, Version("sapphire", "https://pokeapi.co/api/v2/version/8/")),
                GameIndice(132, Version("emerald", "https://pokeapi.co/api/v2/version/9/")),
                GameIndice(132, Version("firered", "https://pokeapi.co/api/v2/version/10/")),
                GameIndice(132, Version("leafgreen", "https://pokeapi.co/api/v2/version/11/")),
                GameIndice(132, Version("diamond", "https://pokeapi.co/api/v2/version/12/")),
                GameIndice(132, Version("pearl", "https://pokeapi.co/api/v2/version/13/")),
                GameIndice(132, Version("platinum", "https://pokeapi.co/api/v2/version/14/")),
                GameIndice(132, Version("heartgold", "https://pokeapi.co/api/v2/version/15/")),
                GameIndice(132, Version("soulsilver", "https://pokeapi.co/api/v2/version/16/")),
                GameIndice(132, Version("black", "https://pokeapi.co/api/v2/version/17/")),
                GameIndice(132, Version("white", "https://pokeapi.co/api/v2/version/18/")),
                GameIndice(132, Version("black-2", "https://pokeapi.co/api/v2/version/21/")),
                GameIndice(132, Version("white-2", "https://pokeapi.co/api/v2/version/22/"))
            ),
            heldItems = listOf(
                HeldItem(
                    item = Item("metal-powder", "https://pokeapi.co/api/v2/item/234/"),
                    versionDetails = listOf(
                        VersionDetail(5, Version("ruby", "https://pokeapi.co/api/v2/version/7/")),
                        VersionDetail(5, Version("sapphire", "https://pokeapi.co/api/v2/version/8/")),
                        VersionDetail(5, Version("emerald", "https://pokeapi.co/api/v2/version/9/")),
                        VersionDetail(5, Version("firered", "https://pokeapi.co/api/v2/version/10/")),
                        VersionDetail(5, Version("leafgreen", "https://pokeapi.co/api/v2/version/11/")),
                        VersionDetail(5, Version("diamond", "https://pokeapi.co/api/v2/version/12/")),
                        VersionDetail(5, Version("pearl", "https://pokeapi.co/api/v2/version/13/")),
                        VersionDetail(5, Version("platinum", "https://pokeapi.co/api/v2/version/14/")),
                        VersionDetail(5, Version("heartgold", "https://pokeapi.co/api/v2/version/15/")),
                        VersionDetail(5, Version("soulsilver", "https://pokeapi.co/api/v2/version/16/")),
                        VersionDetail(5, Version("black", "https://pokeapi.co/api/v2/version/17/")),
                        VersionDetail(5, Version("white", "https://pokeapi.co/api/v2/version/18/")),
                        VersionDetail(5, Version("black-2", "https://pokeapi.co/api/v2/version/21/")),
                        VersionDetail(5, Version("white-2", "https://pokeapi.co/api/v2/version/22/")),
                        VersionDetail(5, Version("x", "https://pokeapi.co/api/v2/version/23/")),
                        VersionDetail(5, Version("y", "https://pokeapi.co/api/v2/version/24/")),
                        VersionDetail(5, Version("omega-ruby", "https://pokeapi.co/api/v2/version/25/")),
                        VersionDetail(5, Version("alpha-sapphire", "https://pokeapi.co/api/v2/version/26/")),
                        VersionDetail(5, Version("sun", "https://pokeapi.co/api/v2/version/27/")),
                        VersionDetail(5, Version("moon", "https://pokeapi.co/api/v2/version/28/")),
                        VersionDetail(5, Version("ultra-sun", "https://pokeapi.co/api/v2/version/29/")),
                        VersionDetail(5, Version("ultra-moon", "https://pokeapi.co/api/v2/version/30/"))
                    )
                ),
                HeldItem(
                    item = Item("quick-powder", "https://pokeapi.co/api/v2/item/251/"),
                    versionDetails = listOf(
                        VersionDetail(50, Version("diamond", "https://pokeapi.co/api/v2/version/12/")),
                        VersionDetail(50, Version("pearl", "https://pokeapi.co/api/v2/version/13/")),
                        VersionDetail(50, Version("platinum", "https://pokeapi.co/api/v2/version/14/")),
                        VersionDetail(50, Version("heartgold", "https://pokeapi.co/api/v2/version/15/")),
                        VersionDetail(50, Version("soulsilver", "https://pokeapi.co/api/v2/version/16/")),
                        VersionDetail(50, Version("black", "https://pokeapi.co/api/v2/version/17/")),
                        VersionDetail(50, Version("white", "https://pokeapi.co/api/v2/version/18/")),
                        VersionDetail(50, Version("black-2", "https://pokeapi.co/api/v2/version/21/")),
                        VersionDetail(50, Version("white-2", "https://pokeapi.co/api/v2/version/22/")),
                        VersionDetail(50, Version("x", "https://pokeapi.co/api/v2/version/23/")),
                        VersionDetail(50, Version("y", "https://pokeapi.co/api/v2/version/24/")),
                        VersionDetail(50, Version("omega-ruby", "https://pokeapi.co/api/v2/version/25/")),
                        VersionDetail(50, Version("alpha-sapphire", "https://pokeapi.co/api/v2/version/26/")),
                        VersionDetail(50, Version("sun", "https://pokeapi.co/api/v2/version/27/")),
                        VersionDetail(50, Version("moon", "https://pokeapi.co/api/v2/version/28/")),
                        VersionDetail(50, Version("ultra-sun", "https://pokeapi.co/api/v2/version/29/")),
                        VersionDetail(50, Version("ultra-moon", "https://pokeapi.co/api/v2/version/30/"))
                    )
                )
            ),
            locationAreaEncounters = "https://pokeapi.co/api/v2/pokemon/132/encounters",
            moves = listOf(
                Move(
                    move = MoveX("transform","https://pokeapi.co/api/v2/move/144/"),
                    versionGroupDetails = listOf(
                        VersionGroupDetail(
                            1,
                            MoveLearnMethod(
                                "level-up",
                                "https://pokeapi.co/api/v2/move-learn-method/1/"
                            ),
                            VersionGroup(
                                "red-blue",
                                "https://pokeapi.co/api/v2/version-group/1/"
                            )
                        ),
                        VersionGroupDetail(
                            1,
                            MoveLearnMethod(
                                "level-up",
                                "https://pokeapi.co/api/v2/move-learn-method/1/"
                            ),
                            VersionGroup(
                                "yellow",
                                "https://pokeapi.co/api/v2/version-group/2/"
                            )
                        ),
                        VersionGroupDetail(
                            1,
                            MoveLearnMethod(
                                "level-up",
                                "https://pokeapi.co/api/v2/move-learn-method/1/"
                            ),
                            VersionGroup(
                                "gold-silver",
                                "https://pokeapi.co/api/v2/version-group/3/"
                            )
                        ),
                        VersionGroupDetail(
                            1,
                            MoveLearnMethod(
                                "level-up",
                                "https://pokeapi.co/api/v2/move-learn-method/1/"
                            ),
                            VersionGroup(
                                "crystal",
                                "https://pokeapi.co/api/v2/version-group/4/"
                            )
                        ),
                        VersionGroupDetail(
                            1,
                            MoveLearnMethod(
                                "level-up",
                                "https://pokeapi.co/api/v2/move-learn-method/1/"
                            ),
                            VersionGroup(
                                "ruby-sapphire",
                                "https://pokeapi.co/api/v2/version-group/5/"
                            )
                        ),
                        VersionGroupDetail(
                            1,
                            MoveLearnMethod(
                                "level-up",
                                "https://pokeapi.co/api/v2/move-learn-method/1/"
                            ),
                            VersionGroup(
                                "emerald",
                                "https://pokeapi.co/api/v2/version-group/6/"
                            )
                        ),
                        VersionGroupDetail(
                            1,
                            MoveLearnMethod(
                                "level-up",
                                "https://pokeapi.co/api/v2/move-learn-method/1/"
                            ),
                            VersionGroup(
                                "firered-leafgreen",
                                "https://pokeapi.co/api/v2/version-group/7/"
                            )
                        ),
                        VersionGroupDetail(
                            1,
                            MoveLearnMethod(
                                "level-up",
                                "https://pokeapi.co/api/v2/move-learn-method/1/"
                            ),
                            VersionGroup(
                                "diamond-pearl",
                                "https://pokeapi.co/api/v2/version-group/8/"
                            )
                        ),
                        VersionGroupDetail(
                            1,
                            MoveLearnMethod(
                                "level-up",
                                "https://pokeapi.co/api/v2/move-learn-method/1/"
                            ),
                            VersionGroup(
                                "platinum",
                                "https://pokeapi.co/api/v2/version-group/9/"
                            )
                        ),
                        VersionGroupDetail(
                            1,
                            MoveLearnMethod(
                                "level-up",
                                "https://pokeapi.co/api/v2/move-learn-method/1/"
                            ),
                            VersionGroup(
                                "heartgold-soulsilver",
                                "https://pokeapi.co/api/v2/version-group/10/"
                            )
                        ),
                        VersionGroupDetail(
                            1,
                            MoveLearnMethod(
                                "level-up",
                                "https://pokeapi.co/api/v2/move-learn-method/1/"
                            ),
                            VersionGroup(
                                "black-white",
                                "https://pokeapi.co/api/v2/version-group/11/"
                            )
                        ),
                        VersionGroupDetail(
                            1,
                            MoveLearnMethod(
                                "level-up",
                                "https://pokeapi.co/api/v2/move-learn-method/1/"
                            ),
                            VersionGroup(
                                "colosseum",
                                "https://pokeapi.co/api/v2/version-group/12/")
                        ),
                        VersionGroupDetail(
                            1,
                            MoveLearnMethod(
                                "level-up",
                                "https://pokeapi.co/api/v2/move-learn-method/1/"
                            ),
                            VersionGroup(
                                "xd",
                                "https://pokeapi.co/api/v2/version-group/13/"
                            )
                        ),
                        VersionGroupDetail(
                            1,
                            MoveLearnMethod(
                                "level-up",
                                "https://pokeapi.co/api/v2/move-learn-method/1/"
                            ),
                            VersionGroup(
                                "black-2-white-2",
                                "https://pokeapi.co/api/v2/version-group/14/"
                            )
                        ),
                        VersionGroupDetail(
                            1,
                            MoveLearnMethod(
                                "level-up",
                                "https://pokeapi.co/api/v2/move-learn-method/1/"
                            ),
                            VersionGroup(
                                "x-y",
                                "https://pokeapi.co/api/v2/version-group/15/"
                            )
                        ),
                        VersionGroupDetail(
                            1,
                            MoveLearnMethod(
                                "level-up",
                                "https://pokeapi.co/api/v2/move-learn-method/1/"
                            ),
                            VersionGroup(
                                "omega-ruby-alpha-sapphire",
                                "https://pokeapi.co/api/v2/version-group/16/"
                            )
                        ),
                        VersionGroupDetail(
                            1,
                            MoveLearnMethod(
                                "level-up",
                                "https://pokeapi.co/api/v2/move-learn-method/1/"
                            ),
                            VersionGroup(
                                "sun-moon",
                                "https://pokeapi.co/api/v2/version-group/17/"
                            )
                        ),
                        VersionGroupDetail(
                            1,
                            MoveLearnMethod(
                                "level-up",
                                "https://pokeapi.co/api/v2/move-learn-method/1/"
                            ),
                            VersionGroup(
                                "ultra-sun-ultra-moon",
                                "https://pokeapi.co/api/v2/version-group/18/"
                            )
                        ),
                        VersionGroupDetail(
                            1,
                            MoveLearnMethod(
                                "level-up",
                                "https://pokeapi.co/api/v2/move-learn-method/1/"
                            ),
                            VersionGroup(
                                "lets-go-pikachu-lets-go-eevee",
                                "https://pokeapi.co/api/v2/version-group/19/"
                            )
                        ),
                        VersionGroupDetail(
                            1,
                            MoveLearnMethod(
                                "level-up",
                                "https://pokeapi.co/api/v2/move-learn-method/1/"
                            ),
                            VersionGroup(
                                "sword-shield",
                                "https://pokeapi.co/api/v2/version-group/20/"
                            )
                        ),
                        VersionGroupDetail(
                            1,
                            MoveLearnMethod(
                                "level-up",
                                "https://pokeapi.co/api/v2/move-learn-method/1/"
                            ),
                            VersionGroup(
                                "brilliant-diamond-and-shining-pearl",
                                "https://pokeapi.co/api/v2/version-group/23/"
                            )
                        ),
                        VersionGroupDetail(
                            1,
                            MoveLearnMethod(
                                "level-up",
                                "https://pokeapi.co/api/v2/move-learn-method/1/"
                            ),
                            VersionGroup(
                                "scarlet-violet",
                                "https://pokeapi.co/api/v2/version-group/25/"
                            )
                        )
                    )
                )
            ),
            pastAbilities = listOf(),
            pastTypes = listOf(),
            species = Species(
                "ditto",
                "https://pokeapi.co/api/v2/pokemon-species/132/"
            ),
            sprites = Sprites(
                backDefault = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/back/132.png",
                backFemale = null,
                backShiny = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/back/shiny/132.png",
                backShinyFemale = null,
                frontDefault = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/132.png",
                frontFemale = null,
                frontShiny = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/shiny/132.png",
                frontShinyFemale = null,
                other = Other(
                    dreamWorld = DreamWorld(
                        "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/dream-world/132.svg",
                        null,
                    ),
                    home = Home(
                        "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/home/132.png",
                        null,
                        "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/home/shiny/132.png",
                        null
                    ),
                    officialArtwork = OfficialArtwork(
                        "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/132.png",
                        "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/shiny/132.png"
                    )
                ),
                versions = Versions(
                    generationI = GenerationI(
                        redBlue = RedBlue(
                            backDefault = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-i/red-blue/back/132.png",
                            backGray = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-i/red-blue/back/gray/132.png",
                            backTransparent = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-i/red-blue/transparent/back/132.png",
                            frontDefault = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-i/red-blue/132.png",
                            frontGray = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-i/red-blue/gray/132.png",
                            frontTransparent = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-i/red-blue/transparent/132.png"
                        ),
                        yellow = Yellow(
                            backDefault = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-i/yellow/back/132.png",
                            backGray = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-i/yellow/back/gray/132.png",
                            backTransparent = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-i/yellow/transparent/back/132.png",
                            frontDefault = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-i/yellow/132.png",
                            frontGray = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-i/yellow/gray/132.png",
                            frontTransparent = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-i/yellow/transparent/132.png"
                        )
                    ),
                    generationIi = GenerationIi(
                        crystal = Crystal(
                            backDefault = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-ii/crystal/back/132.png",
                            backShiny = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-ii/crystal/back/shiny/132.png",
                            backShinyTransparent = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-ii/crystal/transparent/back/shiny/132.png",
                            backTransparent = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-ii/crystal/transparent/back/132.png",
                            frontDefault = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-ii/crystal/132.png",
                            frontShiny = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-ii/crystal/shiny/132.png",
                            frontShinyTransparent = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-ii/crystal/transparent/shiny/132.png",
                            frontTransparent = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-ii/crystal/transparent/132.png"
                        ),
                        gold = Gold(
                            backDefault = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-ii/gold/back/132.png",
                            backShiny = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-ii/gold/back/shiny/132.png",
                            frontDefault = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-ii/gold/132.png",
                            frontShiny = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-ii/gold/shiny/132.png",
                            frontTransparent = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-ii/gold/transparent/132.png"
                        ),
                        silver = Silver(
                            backDefault = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-ii/silver/back/132.png",
                            backShiny = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-ii/silver/back/shiny/132.png",
                            frontDefault = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-ii/silver/132.png",
                            frontShiny = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-ii/silver/shiny/132.png",
                            frontTransparent = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-ii/silver/transparent/132.png"
                        )
                    ),
                    generationIii = GenerationIii(
                        emerald = Emerald(
                            frontDefault = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-iii/emerald/132.png",
                            frontShiny = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-iii/emerald/shiny/132.png"
                        ),
                        fireredLeafgreen = FireredLeafgreen(
                            backDefault = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-iii/firered-leafgreen/back/132.png",
                            backShiny = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-iii/firered-leafgreen/back/shiny/132.png",
                            frontDefault = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-iii/firered-leafgreen/132.png",
                            frontShiny = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-iii/firered-leafgreen/shiny/132.png"
                        ),
                        rubySapphire = RubySapphire(
                            backDefault = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-iii/ruby-sapphire/back/132.png",
                            backShiny = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-iii/ruby-sapphire/back/shiny/132.png",
                            frontDefault = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-iii/ruby-sapphire/132.png",
                            frontShiny = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-iii/ruby-sapphire/shiny/132.png"
                        )
                    ),
                    generationIv = GenerationIv(
                        diamondPearl = DiamondPearl(
                            backDefault = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-iv/diamond-pearl/back/132.png",
                            backFemale = null,
                            backShiny = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-iv/diamond-pearl/back/shiny/132.png",
                            backShinyFemale = null,
                            frontDefault = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-iv/diamond-pearl/132.png",
                            frontFemale = null,
                            frontShiny = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-iv/diamond-pearl/shiny/132.png",
                            frontShinyFemale = null
                        ),
                        heartgoldSoulsilver = HeartgoldSoulsilver(
                            backDefault = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-iv/heartgold-soulsilver/back/132.png",
                            backFemale = null,
                            backShiny = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-iv/heartgold-soulsilver/back/shiny/132.png",
                            backShinyFemale = null,
                            frontDefault = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-iv/heartgold-soulsilver/132.png",
                            frontFemale = null,
                            frontShiny = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-iv/heartgold-soulsilver/shiny/132.png",
                            frontShinyFemale = null
                        ),
                        platinum = Platinum(
                            backDefault = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-iv/platinum/back/132.png",
                            backFemale = null,
                            backShiny = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-iv/platinum/back/shiny/132.png",
                            backShinyFemale = null,
                            frontDefault = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-iv/platinum/132.png",
                            frontFemale = null,
                            frontShiny = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-iv/platinum/shiny/132.png",
                            frontShinyFemale = null
                        )
                    ),
                    generationV = GenerationV(
                        blackWhite = BlackWhite(
                            animated = Animated(
                                backDefault = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-v/black-white/animated/back/132.gif",
                                backFemale = null,
                                backShiny = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-v/black-white/animated/back/shiny/132.gif",
                                backShinyFemale = null,
                                frontDefault = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-v/black-white/animated/132.gif",
                                frontFemale = null,
                                frontShiny = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-v/black-white/animated/shiny/132.gif",
                                frontShinyFemale = null
                            ),
                            backDefault = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-v/black-white/back/132.png",
                            backFemale = null,
                            backShiny = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-v/black-white/back/shiny/132.png",
                            backShinyFemale = null,
                            frontDefault = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-v/black-white/132.png",
                            frontFemale = null,
                            frontShiny = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-v/black-white/shiny/132.png",
                            frontShinyFemale = null
                        )
                    ),
                    generationVi = GenerationVi(
                        omegarubyAlphasapphire = OmegarubyAlphasapphire(
                            frontDefault = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-vi/omegaruby-alphasapphire/132.png",
                            frontFemale = null,
                            frontShiny = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-vi/omegaruby-alphasapphire/shiny/132.png",
                            frontShinyFemale = null
                        ),
                        xY = XY(
                            frontDefault = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-vi/x-y/132.png",
                            frontFemale = null,
                            frontShiny = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-vi/x-y/shiny/132.png",
                            frontShinyFemale = null
                        )
                    ),
                    generationVii = GenerationVii(
                        icons = Icons(
                            frontDefault = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-vii/icons/132.png",
                            frontFemale = null
                        ),
                        ultraSunUltraMoon = UltraSunUltraMoon(
                            frontDefault = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-vii/ultra-sun-ultra-moon/132.png",
                            frontFemale = null,
                            frontShiny = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-vii/ultra-sun-ultra-moon/shiny/132.png",
                            frontShinyFemale = null
                        )
                    ),
                    generationViii = GenerationViii(
                        icons = Icons(
                            frontDefault = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-viii/icons/132.png",
                            frontFemale = null
                        )
                    )
                )
            )
        )
    }

    override suspend fun getPokemonPaginatedResourcesList(limit: Int, offset: Int): PokemonList {

        if(limit == 0 && offset == 0){
            throw Exception("Network Error")
        }

        // Models network response from https://pokeapi.co/api/v2/pokemon/ on 12/22/2023
        return PokemonList(
            count = 1302,
            next = "https://pokeapi.co/api/v2/pokemon/?offset=20&limit=20",
            previous = null,
            results = listOf(
                Result("bulbasaur", "https://pokeapi.co/api/v2/pokemon/1/"),
                Result("ivysaur", "https://pokeapi.co/api/v2/pokemon/2/"),
                Result("venusaur", "https://pokeapi.co/api/v2/pokemon/3/"),
                Result("charmander", "https://pokeapi.co/api/v2/pokemon/4/"),
                Result("charmeleon", "https://pokeapi.co/api/v2/pokemon/5/"),
                Result("charizard", "https://pokeapi.co/api/v2/pokemon/6/"),
                Result("squirtle", "https://pokeapi.co/api/v2/pokemon/7/"),
                Result("wartortle", "https://pokeapi.co/api/v2/pokemon/8/"),
                Result("blastoise", "https://pokeapi.co/api/v2/pokemon/9/"),
                Result("caterpie", "https://pokeapi.co/api/v2/pokemon/10/"),
                Result("metapod", "https://pokeapi.co/api/v2/pokemon/11/"),
                Result("butterfree", "https://pokeapi.co/api/v2/pokemon/12/"),
                Result("weedle", "https://pokeapi.co/api/v2/pokemon/13/"),
                Result("kakuna", "https://pokeapi.co/api/v2/pokemon/14/"),
                Result("beedrill", "https://pokeapi.co/api/v2/pokemon/15/"),
                Result("pidgey", "https://pokeapi.co/api/v2/pokemon/16/"),
                Result("pidgeotto", "https://pokeapi.co/api/v2/pokemon/17/"),
                Result("pidgeot", "https://pokeapi.co/api/v2/pokemon/18/"),
                Result("rattata", "https://pokeapi.co/api/v2/pokemon/19/"),
                Result("raticate", "https://pokeapi.co/api/v2/pokemon/20/")
            )
        )
    }

    override suspend fun getPokemonStatById(id: Int): PokemonStat {

        if(id == 0){
            throw Exception(message = "Network Error")
        }

        // Models network response from https://pokeapi.co/api/v2/stat/1/ on 12/22/2023
        return PokemonStat(
            game_index = 1,
            id = 1,
            is_battle_only = false,
            move_damage_class = null,
            name = "hp",
            affecting_moves = AffectingMoves(
                decrease = listOf(),
                increase = listOf()
            ),
            affecting_natures = AffectingNatures(
                decrease = listOf(),
                increase = listOf(),
            ),
            characteristics = listOf(
                Characteristic("https://pokeapi.co/api/v2/characteristic/1/"),
                Characteristic("https://pokeapi.co/api/v2/characteristic/7/"),
                Characteristic("https://pokeapi.co/api/v2/characteristic/13/"),
                Characteristic("https://pokeapi.co/api/v2/characteristic/19/"),
                Characteristic("https://pokeapi.co/api/v2/characteristic/25/")
            ),
            names = listOf(
                Name(Language("ja-Hrkt", "https://pokeapi.co/api/v2/language/1/"), "HP"),
                Name(Language("ko", "https://pokeapi.co/api/v2/language/3/"), "HP"),
                Name(Language("zh-Hant", "https://pokeapi.co/api/v2/language/4/"), "HP"),
                Name(Language("fr", "https://pokeapi.co/api/v2/language/5/"), "PV"),
                Name(Language("de", "https://pokeapi.co/api/v2/language/6/"), "KP"),
                Name(Language("es", "https://pokeapi.co/api/v2/language/7/"), "PS"),
                Name(Language("it", "https://pokeapi.co/api/v2/language/8/"), "PS"),
                Name(Language("en", "https://pokeapi.co/api/v2/language/9/"), "HP"),
                Name(Language("zh-Hans", "https://pokeapi.co/api/v2/language/12/"), "HP")
            )
        )
    }

    override suspend fun getPokemonStatByName(pokemonName: String): PokemonStat {

        if(pokemonName == "ThrowException"){
            throw Exception("Network Error")
        }

        // Same network response as the one above
        return PokemonStat(
            game_index = 1,
            id = 1,
            is_battle_only = false,
            move_damage_class = null,
            name = "hp",
            affecting_moves = AffectingMoves(
                decrease = listOf(),
                increase = listOf()
            ),
            affecting_natures = AffectingNatures(
                decrease = listOf(),
                increase = listOf(),
            ),
            characteristics = listOf(
                Characteristic("https://pokeapi.co/api/v2/characteristic/1/"),
                Characteristic("https://pokeapi.co/api/v2/characteristic/7/"),
                Characteristic("https://pokeapi.co/api/v2/characteristic/13/"),
                Characteristic("https://pokeapi.co/api/v2/characteristic/19/"),
                Characteristic("https://pokeapi.co/api/v2/characteristic/25/")
            ),
            names = listOf(
                Name(Language("ja-Hrkt", "https://pokeapi.co/api/v2/language/1/"), "HP"),
                Name(Language("ko", "https://pokeapi.co/api/v2/language/3/"), "HP"),
                Name(Language("zh-Hant", "https://pokeapi.co/api/v2/language/4/"), "HP"),
                Name(Language("fr", "https://pokeapi.co/api/v2/language/5/"), "PV"),
                Name(Language("de", "https://pokeapi.co/api/v2/language/6/"), "KP"),
                Name(Language("es", "https://pokeapi.co/api/v2/language/7/"), "PS"),
                Name(Language("it", "https://pokeapi.co/api/v2/language/8/"), "PS"),
                Name(Language("en", "https://pokeapi.co/api/v2/language/9/"), "HP"),
                Name(Language("zh-Hans", "https://pokeapi.co/api/v2/language/12/"), "HP")
            )
        )
    }
}