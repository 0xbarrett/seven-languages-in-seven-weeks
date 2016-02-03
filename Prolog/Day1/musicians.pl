instrument_type(john, guitar).
instrument_type(paul, bass).
instrument_type(ringo, drums).
instrument_type(elton, piano).
instrument_type(miles, trumpet).
instrument_type(merle, guitar).
instrument_type(miley, none).

music_genre(john, rock).
music_genre(paul, rock).
music_genre(ringo, rock).
music_genre(elton, 'pop-rock').
music_genre(miles, jazz).
music_genre(merle, country).
music_genre(miley, annoying).

plays_guitar(X) :- instrument_type(X, guitar).
