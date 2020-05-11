Brugsvejledning til at k�re test
k�r eller k�r coverage for fil SoftwareEngineeringProjekt2/test/RasTesttTunner.java


Brugsvejledning til at k�re program
Kildekoden samt tests er pakket som Eclipse projekt og kan importeres af Eclipse.
Applikationslaget ligger i SoftwareEngineeringProjekt/src/SoftwareEngineringProjekt/src, og brugefladen findes i SoftwareEngineeringProjekt/UI.
For vores softwarel�sning til projektet, er applikationslaget er t�nkt til at k�re mere eller mindre konstant som en f�lles server for firmaet, s� det anbefales, den startes som det f�rste.
For at starte applikationslaget, k�rer filen �Test.java�. Den vil �bne op for serversockets og oprette nogle objekter til test, som nogle bruger, der kan logge p�, samt et projekt med to tilh�rende aktiviteter. De oprettede brugere har initialer: ADMN, CHRJ, CLAL, EIGL, RASN, VICO. 
N�r applikationslaget f�rst er startet, vil det passe sig selv. Nu kan der �bnes en eller flere brugerflader. Brugerfladen �bnes ved at k�re filen �Controll.java�.
 
Der kan logges ind med et af de pre-definerede initialer. Kun �ADMN� er som udgangspunkt tilknyttet et projekt.
Efter brugeren er logget ind, ses et gitter af knapper, samt et tekstfelt med dagen dato. Dette tekstfelt kommer til at indeholde den information, brugeren eftersp�rger eller fejlbeskeder, hvis noget g�r galt undervejs.
Herfra kan brugeren selv v�lge hvilken funktioner, der tages i brug. Det g�res ved at trykke p� en knap for en funktion � alle knapper p� n�r �Se timer brugt� vil �bne et nyt vindue, hvor kriterier for funktionen kan v�lges eller indtastes. For indtastning skal de rigtige formater g�lde � brugerfladen er lavet til at give besked i f�rn�vnte store tekstfelt, hvis noget tastes forkert. 
 
Formater for inputs er relevante for input af dato � b�de som uge og dag � og til dels for input af timer. Ellers har inputs som nye projektnavne ikke nogle s�rlige begr�nsninger. 
�	Dato skal skrives ind som et samlet stykke af DDMM����, s� den 1. maj 2020 skrives som �01052020�.
�	Uge skal skrives ind som �rstal f�rst og s� uge, men adskilt med et punktum, som ����.U, s� den 18. uge i 2020 skrives som �2020.18�.
�	Timer indtastes altid i halve timer. Hvis brugeren har arbejdet 5 timer og vil indmelde det, skal der alts� indtastes �10�. 
For en god tests skyld, anbefales f�rst at lave et eller to nye projekter, da der som n�vn kun oprettes et enkelt, n�r serveren initieres. Derefter kan man oprette nogle aktiviteter til projekterne, tildele projekterne til nogle udviklere, der s� kan begynde at indmelde deres tid til dem.
Opret Projekt skal bruge en leder til det nye projekt, der v�lges fra en dropdown af alle firmaets medarbejdere. Ellers skal der indtastes navn p� projektet, startdato og slutdato.
Bestil ny aktivitet vil kr�ve, brugeren er leder af et projekt, da der skal v�lges ud fra dem i en dropdown. Inputs er ellers den nye aktivitets navn, startuge, slutuge og hvor mange halve arbejdstimer der forventes at skulle blive brugt.
 
Tildel opgaver til udviklere eller s�g hj�lp fra... har n�ste samme funktion, at de giver en ny medarbejder mulighed for at arbejde p� en bestemt aktivitet. For Tildel opgaver til udviklere, kan der tilf�jes medarbejdere til aktiviteter, brugeren er leder for, hvor S�g hj�lp fra� kan tilf�je til alle aktiviteter, brugeren selv arbejder p�. Alt v�lges her fra dropdowns � projekt, aktivitet og bruger, der skal kunne hj�lpe.
Registrer fremtidig frav�r bruges til at angive en periode, hvor brugeren ikke har kan arbejde p� noget grundet fx ferie eller sygdom. Her indtastes en start- og slutdato. Der kan kun registreres for �t �r ad gangen, s� hvis en ferie g�r over et �rsskifte, skal der registreres to gange.
Se timer brugt er den eneste knap, der ikke kr�ver yderligere input. Den henter brugerens arbejdstimer for den nuv�rende dag.
Ret registrerede timer og indmeld timer har samme funktionalitet i at kunne angive, hvor l�nge man har arbejdet p� en given aktivitet p� en given dato. Projekt og aktivitet v�lges fra dropdown, og tekstinputs er dato og halve timer brugt.
Se udvikling af timer p� aktivitet kan projektledere bruge til at se, hvor mange timer, der er blevet brugt p� enkelte aktiviteter, valgt fra dropdown.
Skaf rapporter minder om den tidligere funktion, men giver en oversigt af alle aktiviteter i et valg projekt, samt samlet timeforbrug.
