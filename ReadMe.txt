Brugsvejledning til at køre test
kør eller kør coverage for fil SoftwareEngineeringProjekt2/test/RasTesttTunner.java


Brugsvejledning til at køre program
Kildekoden samt tests er pakket som Eclipse projekt og kan importeres af Eclipse.
Applikationslaget ligger i SoftwareEngineeringProjekt/src/SoftwareEngineringProjekt/src, og brugefladen findes i SoftwareEngineeringProjekt/UI.
For vores softwareløsning til projektet, er applikationslaget er tænkt til at køre mere eller mindre konstant som en fælles server for firmaet, så det anbefales, den startes som det første.
For at starte applikationslaget, kører filen ”Test.java”. Den vil åbne op for serversockets og oprette nogle objekter til test, som nogle bruger, der kan logge på, samt et projekt med to tilhørende aktiviteter. De oprettede brugere har initialer: ADMN, CHRJ, CLAL, EIGL, RASN, VICO. 
Når applikationslaget først er startet, vil det passe sig selv. Nu kan der åbnes en eller flere brugerflader. Brugerfladen åbnes ved at køre filen ”Controll.java”.
 
Der kan logges ind med et af de pre-definerede initialer. Kun ”ADMN” er som udgangspunkt tilknyttet et projekt.
Efter brugeren er logget ind, ses et gitter af knapper, samt et tekstfelt med dagen dato. Dette tekstfelt kommer til at indeholde den information, brugeren efterspørger eller fejlbeskeder, hvis noget går galt undervejs.
Herfra kan brugeren selv vælge hvilken funktioner, der tages i brug. Det gøres ved at trykke på en knap for en funktion – alle knapper på nær ”Se timer brugt” vil åbne et nyt vindue, hvor kriterier for funktionen kan vælges eller indtastes. For indtastning skal de rigtige formater gælde – brugerfladen er lavet til at give besked i førnævnte store tekstfelt, hvis noget tastes forkert. 
 
Formater for inputs er relevante for input af dato – både som uge og dag – og til dels for input af timer. Ellers har inputs som nye projektnavne ikke nogle særlige begrænsninger. 
•	Dato skal skrives ind som et samlet stykke af DDMMÅÅÅÅ, så den 1. maj 2020 skrives som ”01052020”.
•	Uge skal skrives ind som årstal først og så uge, men adskilt med et punktum, som ÅÅÅÅ.U, så den 18. uge i 2020 skrives som ”2020.18”.
•	Timer indtastes altid i halve timer. Hvis brugeren har arbejdet 5 timer og vil indmelde det, skal der altså indtastes ”10”. 
For en god tests skyld, anbefales først at lave et eller to nye projekter, da der som nævn kun oprettes et enkelt, når serveren initieres. Derefter kan man oprette nogle aktiviteter til projekterne, tildele projekterne til nogle udviklere, der så kan begynde at indmelde deres tid til dem.
Opret Projekt skal bruge en leder til det nye projekt, der vælges fra en dropdown af alle firmaets medarbejdere. Ellers skal der indtastes navn på projektet, startdato og slutdato.
Bestil ny aktivitet vil kræve, brugeren er leder af et projekt, da der skal vælges ud fra dem i en dropdown. Inputs er ellers den nye aktivitets navn, startuge, slutuge og hvor mange halve arbejdstimer der forventes at skulle blive brugt.
 
Tildel opgaver til udviklere eller søg hjælp fra... har næste samme funktion, at de giver en ny medarbejder mulighed for at arbejde på en bestemt aktivitet. For Tildel opgaver til udviklere, kan der tilføjes medarbejdere til aktiviteter, brugeren er leder for, hvor Søg hjælp fra… kan tilføje til alle aktiviteter, brugeren selv arbejder på. Alt vælges her fra dropdowns – projekt, aktivitet og bruger, der skal kunne hjælpe.
Registrer fremtidig fravær bruges til at angive en periode, hvor brugeren ikke har kan arbejde på noget grundet fx ferie eller sygdom. Her indtastes en start- og slutdato. Der kan kun registreres for ét år ad gangen, så hvis en ferie går over et årsskifte, skal der registreres to gange.
Se timer brugt er den eneste knap, der ikke kræver yderligere input. Den henter brugerens arbejdstimer for den nuværende dag.
Ret registrerede timer og indmeld timer har samme funktionalitet i at kunne angive, hvor længe man har arbejdet på en given aktivitet på en given dato. Projekt og aktivitet vælges fra dropdown, og tekstinputs er dato og halve timer brugt.
Se udvikling af timer på aktivitet kan projektledere bruge til at se, hvor mange timer, der er blevet brugt på enkelte aktiviteter, valgt fra dropdown.
Skaf rapporter minder om den tidligere funktion, men giver en oversigt af alle aktiviteter i et valg projekt, samt samlet timeforbrug.
