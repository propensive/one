# Niveau

**Take Scala to Another Level!**

_Niveau_ is a loose collection of open-source libraries designed to take full advantage of new
features of Scala 3 to write web and command-line applications, with a focus on lifting more
operations to the type-level.

Niveau includes libraries for working with [HTML](https://github.com/propensive/honeycomb/),
[CSS](https://github.com/propensive/cataract/), [JSON](https://github.com/propensive/euphemism/),
[XML](https://github.com/propensive/xylophone/), [CSV](https://github.com/propensive/caesura/),
[typesafe strings](https://github.com/propensive/gossamer/),
[ANSI-escaped strings](https://github.com/propensive/escapade/) and
[Markdown](https://github.com/propensive/punctuation/), interacting over
[HTTP](https://github.com/propensive/scintillate/) or the
[command line](https://github.com/propensive/exoskeleton/). Additionally, support for
[disk I/O](https://github.com/propensive/jovian/),
[shell processes](https://github.com/propensive/guillotine/) (including native
[keyboard interactivity](https://github.com/propensive/rivulet/)),
[cryptographic functions](https://github.com/propensive/gastronomy/),
[tabular output](https://github.com/propensive/escritoire/) and
[regular expressions](https://github.com/propensive/kaleidoscope/) is provided, and includes
representations of [colors](https://github.com/propensive/iridescence/),
[directed acyclic graphs](https://github.com/propensive/acyclicity/),
[multilingual strings](https://github.com/propensive/cosmopolite/),
[MIME types](https://github.com/propensive/gesticulate/) and
[paths](https://github.com/propensive/slalom/). Fundamental to these projects are utilities for
[generic derivation](https://github.com/propensive/wisteria/),
[checked interpolated strings](https://github.com/propensive/contextual/),
[annotations](https://github.com/propensive/adversaria/), library
[decoupling](https://github.com/propensive/clairvoyant/) and
[unit testing](https://github.com/propensive/probably/) with a
[WebDriver API](https://github.com/propensive/tarantula/) for browser testing. Everything builds
upon minimal set of [common tools](https://github.com/propensive/rudiments/).

## Principles

Each library under the _Niveau_ umbrella embraces the following principles:

- typesafe—taking full advantage of the Scala 3 typesystem
- checked exceptions—but only if you choose to use them
- safe literals—interpolated strings, checked at compiletime with
  [Contextual](https://github.com/propensive/contextual/)
- typeclasses—extensibility provided through
  [Wisteria](https://github.com/propensive/wisteria/)'s generic derivation
- decoupled—modules use [Clairvoyant](https://github.com/propensive/clairvoyant/) to minimise
  unnecessary dependencies
- small APIs—above all, code should be legible, natural and elegant

### Typesafe

Scala 3's typesystem offers a rich variety of types for representing and combining constraints on
values. This presents an opportunity to encode a value's invariants—facts about the value which we
know will always be true—precisely in its type. These invariants then give us certainty that
operations involving the value are safe. Or, that they're simply impossible. In general, this
reduces the amount of branching, including exception handling, that's required in code. Extensive
use of immutable datatypes adds further guarantees.

### Checked Exceptions

The latest release of Scala 3 introduces opt-in exception checking, and every Niveau method declares
the exceptions it may throw in its signature. This makes it easy to write prototype code with
a "let it fail" attitude and exception-checking off, and to migrate to production-quality code just
by turning exception-checking on, and having the compiler require handlers for each exception—but
without needing to transform types or switch to a monadic coding style.

Effectively, this transforms every partial function into a total function; when combined with the
wise philosophy of making impossible states unrepresentable, exceptions become even more
exceptional.

### Safe Literals

When constructing a value, such as a JSON object or a URL, from a string literal, all the
information is available at compiletime to check the validity of the string's contents. So,
whenever possible, this is provided with interpolated strings, such as `url"https://github.com/"`,
using [Contextual](https://github.com/propensive/contextual/). Since checks are performed at
compiletime, there is no risk of runtime exceptions arising from these values.

### Typeclasses

The typeclass pattern, provided through contextual values (`given`s) is used extensively by
Niveau libraries to provide ad-hoc polymorphism (in preference to subtype polymorphism). This not
only allows user-defined types to participate naturally in all kinds of Niveau APIs, but also
facilitates interaction between Niveau libraries and third-party libraries.

### Decoupled

When working with libraries in different domains, it is common to need integration between them.
For example, an HTTP server should be able to serve a XML value with the correct MIME type, without
too much boilerplate. That is easily achieved by making one library a dependency of the other. But
the user of a XML library should not need to include an HTTP server (nor should an HTTP server
require a XML library). The solution is to make use of minimal typeclasses provided by
[Clairvoyant](https://github.com/propensive/clairvoyant/) to maximally decouple independent
libraries.

### Small APIs

Every API introduced by a Niveau library should fit on one side of a business card. It should never
be difficult to learn, and composition of APIs should be preferred over specialized solutions. Names
should be meaningful and appropriately unique: that is to say, sharing a name with an existing
concept or entity if they represent that entity, but introducing new nomenclature if they represent
something new. Short names are preferred, but arbitrarily-abbreviated names are not. Objects are
primarily composed through selection (the `.` operator) and application, rather than monadic mapping
and flat-mapping, since exceptional cases may be handled with checking. The amount of code in each
library should also be small.

### Other common features

- extensive use of the immutable `IArray[Byte]` type for random-access byte-data
- streaming provided using `LazyList`s
- the `Txt` type provides an more typesafe alternative opaque type alias for `String`s
- all libraries are compiled with `null`-checking enabled—and `null`s forbidden!
- use of the `T | Unset` union type for optional parameters, without the need to wrap `T` in `Some` or use `null`