# Bibliotekssystem

Ett enkelt konsolbaserat bibliotekshanteringssystem implementerat i Java. Systemet gör det möjligt för användare att hantera böcker, DVD:er och användarkonton samt hantera utlåning och återlämning av media. Systemet inkluderar även sökfunktionalitet för media i biblioteket.

## Funktioner
- **Användarregistrering**: Stöd för vanliga användare och VIP-användare med olika låneperioder.
- **Mediemanagement**: Lägg till böcker, DVD:er och tidskrifter i bibliotekets samling.
- **Utlåningssystem**: Användare kan låna och återlämna media, och systemet beräknar automatiskt återlämningsdatum.
- **Mediasökning**: Användare kan söka efter media med titeln.
- **Återlämningssystem**: Återlämna lånade objekt och uppdatera systemet.

## Installation
- Klona repot:
    ```bash
    git clone https://github.com/ditt-repo/bibliotekssystem.git
    ```
## Användning
När applikationen körs visas en meny. Använd följande alternativ för att navigera i systemet:

- **1. Registrera användare**: Lägg till nya användare, antingen en vanlig användare eller en VIP-användare.
- **2. Lägg till media**: Lägg till en bok eller DVD i bibliotekets samling.
- **3. Låna media**: Låna media från biblioteket. Endast registrerade användare kan låna objekt.
- **4. Returnera media**: Returnera lånad media.
- **5. Sök efter media**: Sök i biblioteket efter titel.
- **6. Avsluta**: Avsluta applikationen.

### Exempel:
```bash
=== Bibliotekssystem ===

1.Registrera användare
2.Lägg till media (Bok/DVD)
3.Låna media
4.Returnera media
5.Sök efter media
6.Avsluta Välj ett alternativ:
```
## Klasser

- **Main**: Applikationens startpunkt.
- **LibrarySystem**: Kärnfunktioner i systemet, inklusive meny, användarregistrering och mediehantering.
- **Media**: Abstrakt klass som representerar medieobjekt i biblioteket.
- **Book**: Subklass till Media för att hantera böcker.
- **DVD**: Subklass till Media för att hantera DVD:er.
- **User**: Abstrakt klass som representerar bibliotekets användare.
- **RegularMember**: Subklass till User för vanliga användare.
- **VIPMember**: Subklass till User för VIP-användare.
- **Loan**: Klass som hanterar utlåning av media.

## Projektstatus

Detta projekt är för närvarande under utveckling. Alla funktioner är inte helt implementerade, och det kan förekomma buggar eller ofullständig funktionalitet. Framtida uppdateringar och förbättringar är planerade. Känn dig fri att återkomma eller bidra till projektet.
Vi uppskattar verkligen all feedback eller förslag för att förbättra projektet. Din feedback hjälper oss att göra projektet bättre.

## Krav
- Java 8 eller senare