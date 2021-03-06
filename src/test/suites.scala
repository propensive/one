package one

import probably.*
import rudiments.*
import gossamer.*
import eucalyptus.*

given log: Log = Log(Everything |-> Stdout)

object Tests extends Suite(t"Scala One tests"):
  def run(using Runner): Unit =
    suite(adversaria.Tests)
    suite(acyclicity.Tests)
    suite(caesura.Tests)
    suite(cataclysm.Tests)
    suite(contextual.Tests)
    //suite(cosmopolite.Tests)
    suite(escapade.Tests)
    suite(escritoire.Tests)
    suite(euphemism.Tests)
    suite(exoskeleton.Tests)
    suite(gastronomy.Tests)
    suite(gesticulate.Tests)
    suite(gossamer.Tests)
    suite(guillotine.Tests)
    suite(honeycomb.Tests)
    suite(iridescence.Tests)
    suite(joviality.Tests)
    suite(kaleidoscope.Tests)
    suite(probably.Tests)
    suite(punctuation.Tests)
    suite(profanity.Tests)
    suite(rudiments.Tests)
    suite(scintillate.Tests)
    suite(serpentine.Tests)
    suite(tarantula.Tests)
    suite(wisteria.Tests)
    suite(xylophone.Tests)
